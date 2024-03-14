package org.atelier.tennisplayer.infrstructure.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.atelier.tennisplayer.domain.model.Player;
import org.atelier.tennisplayer.domain.port.out.TennisPlayerRepository;
import org.atelier.tennisplayer.infrstructure.model.PlayerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class TennisPlayerRetriever implements TennisPlayerRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(TennisPlayerRetriever.class);
    private final ObjectMapper objectMapper;
    private List<PlayerResponse> players;

    public TennisPlayerRetriever(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    private void init() {
        try {
            players = objectMapper.readValue(
                    new ClassPathResource("players.json").getInputStream(),
                    new TypeReference<>() {}
            );
        } catch (IOException e) {
            LOGGER.warn("Failed to load players data");
        }
    }

    @Override
    public List<Player> retrieveTennisPlayers() {
        return players.stream()
                .map(PlayerResponse::toPlayer)
                .toList();
    }
}
