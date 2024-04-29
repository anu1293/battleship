package games.gamestrategies.terminalcondition;

import players.Player;

public interface TerminalConditionStrategy {
    boolean getTerminalCondition(Player[] players);
}
