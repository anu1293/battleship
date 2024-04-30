package games.gamestrategies.playerselection;

import players.Player;

public interface PlayerSelectionStrategy {
    Player getNextPlayer(Player[] players);
}
