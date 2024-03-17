package org.atelier.tennisplayer.domain.port.in;

import org.atelier.tennisplayer.domain.model.Statistics;
import org.atelier.tennisplayer.domain.model.TennisPlayer;

import java.util.List;
import java.util.Optional;

public interface TennisPlayerUseCase {
    List<TennisPlayer> retrieveSortedPlayers();

    Optional<TennisPlayer> retrievePlayerById(int playerId);

    Statistics retrieveStatistics();
}
