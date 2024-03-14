package org.atelier.tennisplayer.domain.port.out;

import org.atelier.tennisplayer.domain.model.Player;

import java.util.List;

public interface TennisPlayerRepository {
    List<Player> retrieveTennisPlayers();
}
