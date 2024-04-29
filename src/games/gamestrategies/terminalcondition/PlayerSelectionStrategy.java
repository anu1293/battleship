package games.gamestrategies.terminalcondition;

import players.Player;

public interface PlayerSelectionStrategy {
    Player getNextPlayer(Player[] players);
}
