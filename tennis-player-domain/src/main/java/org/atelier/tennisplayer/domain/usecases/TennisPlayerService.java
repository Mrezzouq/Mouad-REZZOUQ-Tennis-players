package org.atelier.tennisplayer.domain.usecases;

import org.atelier.tennisplayer.domain.exception.TennisPlayerNotFoundException;
import org.atelier.tennisplayer.domain.model.Statistics;
import org.atelier.tennisplayer.domain.model.TennisPlayer;
import org.atelier.tennisplayer.domain.port.in.TennisPlayerUseCase;
import org.atelier.tennisplayer.domain.port.out.TennisPlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TennisPlayerService implements TennisPlayerUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TennisPlayerService.class);
    private final TennisPlayerRepository tennisPlayerRepository;

    public TennisPlayerService(TennisPlayerRepository tennisPlayerRepository) {
        this.tennisPlayerRepository = tennisPlayerRepository;
    }

    @Override
    public List<TennisPlayer> retrieveSortedPlayers() {
        return this.tennisPlayerRepository.retrieveTennisPlayers()
                .stream()
                .sorted(Comparator.comparingInt(player -> player.additionalData().rank()))
                .toList();
    }

    @Override
    public Optional<TennisPlayer> retrievePlayerById(int playerId) {
        try {
            return Optional.of(this.tennisPlayerRepository.retrievePlayerById(playerId));
        } catch (TennisPlayerNotFoundException e) {
            LOGGER.warn("No player found with ID: {}", playerId);
            return Optional.empty();
        }
    }

    @Override
    public Statistics retrieveStatistics() {
        var tennisPlayers = this.tennisPlayerRepository.retrieveTennisPlayers();
        return Statistics.builder()
                .withCountryWithHighestWinRatio(getCountryWithHighestWinRatio(tennisPlayers))
                .withAverageBmi(getAverageBmi(tennisPlayers))
                .withMedianHeight(getMedianHeight(tennisPlayers))
                .build();
    }

    private String getCountryWithHighestWinRatio(List<TennisPlayer> players) {
        return players.stream()
                .collect(Collectors.groupingBy(
                        player -> player.playerCountry().code(),
                        Collectors.averagingDouble(player -> player.additionalData().last().stream().mapToInt(Integer::intValue).average().orElse(0.0))
                ))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }

    private BigDecimal getAverageBmi(List<TennisPlayer> players) {
        if (players.isEmpty()) return BigDecimal.ZERO;
        return players.stream()
                .map(player -> {
                    var weight = BigDecimal.valueOf(player.additionalData().weight()).divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP);
                    var heightInMeters = BigDecimal.valueOf(player.additionalData().height()).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
                    return weight.divide(heightInMeters.pow(2), 2, RoundingMode.HALF_UP);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(this.tennisPlayerRepository.retrieveTennisPlayers().size()), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal getMedianHeight(List<TennisPlayer> players) {
        var heights = players.stream()
                .map(tennisPlayer -> tennisPlayer.additionalData().height())
                .sorted()
                .toList();
        if (heights.isEmpty()) {
            return BigDecimal.ZERO;
        }
        var middle = heights.size() / 2;
        if (heights.size() % 2 == 1) {
            return BigDecimal.valueOf(heights.get(middle));
        } else {
            return BigDecimal.valueOf(heights.get(middle - 1) + heights.get(middle)).divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP);
        }
    }
}
