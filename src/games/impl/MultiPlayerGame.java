package games.impl;

import battlegrounds.BattleGroundAllocationStrategy;
import games.gamestrategies.winner.WinnerStrategy;
import games.gamestrategies.GameStrategy;
import missile.missileinitilizer.MissileSequenceInitializer;
import players.initializers.PlayerInitializer;
import players.visitors.MultiplayerInitializerVisitor;
import ships.strategies.ShipPlacementStrategy;
import ships.initializers.ShipCreationStrategy;


public class MultiPlayerGame extends AbstractBattleShipGame {


    public MultiPlayerGame(ShipCreationStrategy shipCreationStrategy,
                           ShipPlacementStrategy placementStrategy,
                           WinnerStrategy winnerStrategy,
                           BattleGroundAllocationStrategy battleGroundAllocationStrategy,
                           PlayerInitializer playerInitializer,
                           MissileSequenceInitializer missileSequenceInitializer,
                           GameStrategy gameStrategy) {
        super(shipCreationStrategy,placementStrategy,winnerStrategy,battleGroundAllocationStrategy,playerInitializer,missileSequenceInitializer,gameStrategy);
        visitor = new MultiplayerInitializerVisitor();
    }
}
