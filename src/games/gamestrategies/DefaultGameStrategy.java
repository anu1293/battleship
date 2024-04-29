package games.gamestrategies;

import games.gamestrategies.terminalcondition.PlayerSelectionStrategy;
import games.gamestrategies.terminalcondition.TerminalConditionStrategy;
import missile.Missile;
import players.Player;

import java.util.List;

public class DefaultGameStrategy implements GameStrategy {

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
        int currentPlayerIndex = 0;
        boolean shouldContinueWithSamePlayer = true;
        boolean isHit;
        Player currentPlayer = playerSelectionStrategy.getNextPlayer(players);
        while (terminalConditionStrategy.getTerminalCondition(players)) {
            List<Missile> missileSequence =  currentPlayer.getMissileSequence();
            if(shouldContinueWithSamePlayer && currentPlayer.getMissileSequence().size()>0) {
                Missile missile = missileSequence.get(0);
                isHit = currentPlayer.fireMissile(missile,missile.getOpponent());
                missileSequence.remove(0);
                if (isHit) {
                    System.out.println("Player " + (currentPlayerIndex + 1) + " fires a missile with target (" + (char)(missile.getXCoordinate()+'A'-1) +","+missile.getYCoordinate()+") : hit");
                } else {
                    System.out.println("Player " + (currentPlayerIndex + 1) + " fires a missile with target (" + (char)(missile.getXCoordinate()+'A'-1) +","+missile.getYCoordinate()+"): miss");
                }
                shouldContinueWithSamePlayer=isHit;
            } else {
                currentPlayer = playerSelectionStrategy.getNextPlayer(players);
                currentPlayerIndex =(currentPlayerIndex + 1) % players.length;
                shouldContinueWithSamePlayer = true;
            }

        }
    }
}
