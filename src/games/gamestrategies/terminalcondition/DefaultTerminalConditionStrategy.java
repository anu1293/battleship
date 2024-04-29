package games.gamestrategies.terminalcondition;

import games.gamestrategies.terminalcondition.TerminalConditionStrategy;
import players.Player;

import java.util.Arrays;

public class DefaultTerminalConditionStrategy implements TerminalConditionStrategy {

    @Override
    public boolean getTerminalCondition(Player[] players) {
        return getTotalPlayersAliveCount(players)>1 && getTotalMissiles(players)>0;
    }

    private int getTotalPlayersAliveCount(Player[] players) {
        return Arrays.stream(players).filter(player->player.getRemainingShips()>0).mapToInt(player->1).sum();
    }

    public int getTotalMissiles(Player[] players) {
        return Arrays.stream(players).mapToInt(player-> player.getMissileSequence().size()).sum();
    }
}
