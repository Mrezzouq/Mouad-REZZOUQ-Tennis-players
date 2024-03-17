package org.atelier.tennisplayer.domain.port.out;

import org.atelier.tennisplayer.domain.model.TennisPlayer;

import java.util.List;

public interface TennisPlayerRepository {
    List<TennisPlayer> retrieveTennisPlayers();

    TennisPlayer retrievePlayerById(int playerId);
}
