package games.gamestrategies;

import games.gamestrategies.playerselection.PlayerSelectionStrategy;
import games.gamestrategies.terminalcondition.TerminalConditionStrategy;
import players.Player;

public class DefaultGameStrategy implements  GameStrategy {

    PlayerSelectionStrategy playerSelectionStrategy;
    TerminalConditionStrategy terminalConditionStrategy;

    public DefaultGameStrategy(PlayerSelectionStrategy playerSelectionStrategy,
    TerminalConditionStrategy terminalConditionStrategy
    ) {
        this.playerSelectionStrategy = playerSelectionStrategy;
        this.terminalConditionStrategy = terminalConditionStrategy;
    }

    @Override
    public void play(Player[] players) {
        boolean shouldContinueWithSamePlayer = true;
        Player currentPlayer = playerSelectionStrategy.getNextPlayer(players);
        while (terminalConditionStrategy.getTerminalCondition(players)) {
            if(shouldContinueWithSamePlayer && currentPlayer.getMissileSequence().size()>0) {
                shouldContinueWithSamePlayer = currentPlayer.fireMissile();
            } else {
                currentPlayer = playerSelectionStrategy.getNextPlayer(players);
                shouldContinueWithSamePlayer = true;
            }
        }
    }
}
