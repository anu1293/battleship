package factories;


import battlegrounds.BattleGroundAllocationStrategy;
import games.BattleShipGame;
import games.GameMode;
import games.gamestrategies.winner.WinnerStrategy;
import games.gamestrategies.GameStrategy;
import games.impl.MultiPlayerGame;
import games.impl.TwoPlayerGame;
import missile.missileinitilizer.MissileSequenceInitializer;
import players.initializers.PlayerInitializer;
import ships.strategies.ShipPlacementStrategy;
import ships.initializers.ShipCreationStrategy;

public class BattleShipGameFactory {

    public static BattleShipGame initializeGame(GameMode type, ShipCreationStrategy shipCreationStrategy,
                                                ShipPlacementStrategy placementStrategy,
                                                WinnerStrategy winnerStrategy,
                                                BattleGroundAllocationStrategy battleGroundAllocationStrategy, PlayerInitializer playerInitializer,
                                                MissileSequenceInitializer missileSequenceInitializer,
                                                GameStrategy gameStrategy) {
        switch(type) {
            case DOUBLE_PLAYER -> {
                return new TwoPlayerGame(shipCreationStrategy,placementStrategy, winnerStrategy, battleGroundAllocationStrategy,playerInitializer,missileSequenceInitializer,gameStrategy);
            }
            case MULTI_PLAYER -> {
                return new MultiPlayerGame(shipCreationStrategy,placementStrategy, winnerStrategy, battleGroundAllocationStrategy,playerInitializer,missileSequenceInitializer,gameStrategy);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
