package games.impl;

import games.gamestrategies.GameStrategy;
import missile.missileinitilizer.MissileSequenceInitializer;
import battlegrounds.BattleGroundAllocationStrategy;
import games.BattleShipGame;
import games.gamestrategies.winner.WinnerStrategy;
import players.Player;
import players.initializers.PlayerInitializer;
import players.visitors.PlayerInitializerVisitor;
import ships.ShipPlacementStrategy;
import ships.initializers.ShipCreationStrategy;

public abstract class AbstractBattleShipGame implements BattleShipGame {

    Player[] players;
    ShipPlacementStrategy placementStrategy;
    WinnerStrategy winnerStrategy;
    BattleGroundAllocationStrategy battleGroundAllocationStrategy;
    ShipCreationStrategy shipCreationStrategy;
    PlayerInitializerVisitor visitor;
    PlayerInitializer playerInitializer;
    MissileSequenceInitializer missileSequenceInitializer;
    GameStrategy gameStrategy;

    public AbstractBattleShipGame(ShipCreationStrategy shipCreationStrategy,
                                  ShipPlacementStrategy placementStrategy,
                                  WinnerStrategy winnerStrategy,
                                  BattleGroundAllocationStrategy battleGroundAllocationStrategy,
                                  PlayerInitializer playerInitializer,
                                  MissileSequenceInitializer missileSequenceInitializer,
                                  GameStrategy gameStrategy

    ) {
        this.placementStrategy = placementStrategy;
        this.winnerStrategy = winnerStrategy;
        this.battleGroundAllocationStrategy = battleGroundAllocationStrategy;
        this.shipCreationStrategy = shipCreationStrategy;
        this.playerInitializer = playerInitializer;
        this.missileSequenceInitializer = missileSequenceInitializer;
        this.gameStrategy = gameStrategy;
    }

    @Override
    public void initialize() throws Exception {
        createPlayers(playerInitializer);
        battleGroundAllocationStrategy.initializeBattleGround(players);
        shipCreationStrategy.createShip(players);
        placementStrategy.placeShip(players);
        initializeMissileSequence(missileSequenceInitializer);
    }

    protected void createPlayers(PlayerInitializer initializer) throws Exception {
        players = initializer.initializePlayers(visitor);
    }
    protected void initializeMissileSequence(MissileSequenceInitializer initializer) throws Exception {
        initializer.initializeMissileSequence(visitor,players);
    }
    public void playGame() {
        this.gameStrategy.play(players);
    }
    public void getWinner() {
        winnerStrategy.getWinner(players);
    }


}

