package games.gamestrategies.playerselection;

import games.gamestrategies.terminalcondition.PlayerSelectionStrategy;
import players.Player;

public class RoundRobinSelectionStrategy implements PlayerSelectionStrategy {
    int index=-1;
    @Override
    public Player getNextPlayer(Player[] players) {
        if(index==-1) {
            index=0;
        } else {
            index=(index+1)%players.length;
        }
        return players[index];
    }
}
