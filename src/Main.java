import battlegrounds.BattleGroundAllocationStrategy;
import battlegrounds.BattleGroundType;
import battlegrounds.DefaultBattleGroundAllocationStrategy;
import factories.BattleGroundFactory;
import factories.BattleGroundFactoryOfFactories;
import factories.BattleShipGameFactory;
import factories.RectangularBattleGroundFactory;
import games.*;
import games.gamestrategies.DefaultGameStrategy;
import games.gamestrategies.terminalcondition.DefaultTerminalConditionStrategy;
import games.gamestrategies.GameStrategy;
import games.gamestrategies.playerselection.RoundRobinSelectionStrategy;
import games.gamestrategies.winner.DefaultWinnerStrategy;
import games.gamestrategies.winner.WinnerStrategy;
import missile.missileinitilizer.MissileSequenceInitializer;
import missile.missileinitilizer.TwoPlayerMissileInitializer;
import players.PlayerType;
import players.initializers.PlayerInitializer;
import players.initializers.TwoPlayerInitializer;
import ships.DefaultPlacementStrategy;
import ships.ShipPlacementStrategy;
import ships.ShipType;
import ships.initializers.EqualShipPerPlayerStrategy;
import ships.initializers.ShipCreationStrategy;

public class Main {
    public static void main(String[] args) throws Exception {

        GameMode mode = GameMode.valueOf("DOUBLE_PLAYER");
        String[] dimensions = "5 E".split(" ");

        int battleAreaWidth = Integer.parseInt(dimensions[0]);
        int battleAreaHeight = dimensions[1].charAt(0) - 'A' + 1;
        int numShips = 2;

        ShipType[] shipTypes = new ShipType[2];
        shipTypes[0]=ShipType.Q;
        shipTypes[1]=ShipType.P;

        int[] height = new int[2];
        int[] width = new int[2];

        height[0]= 1;
        height[1]=2;
        width[0]=1;
        width[1]=1;

        PlayerType[] types = new PlayerType[2];
        types[0]=PlayerType.HUMAN;
        types[1]=PlayerType.HUMAN;

        int[][] xCoordinate=new int[2][2];
        int[][] yCoordinate=new int[2][2];

        xCoordinate[0][0]=1;
        xCoordinate[0][1]=4;
        xCoordinate[1][0]=2;
        xCoordinate[1][1]=3;

        yCoordinate[0][0]=1;
        yCoordinate[0][1]=4;
        yCoordinate[1][0]=2;
        yCoordinate[1][1]=3;

        String[] sequence = new String[2];
        sequence[0] = "A1 B2 B2 B3";
        sequence[1] = "A1 B2 B3 A1 D1 E1 D4 D4 D5 D5";

        BattleGroundFactory battleGroundFactory = BattleGroundFactoryOfFactories.getBattleGroundFactory(BattleGroundType.RECTANGULAR);
        ((RectangularBattleGroundFactory)battleGroundFactory).setHeight(battleAreaHeight);
        ((RectangularBattleGroundFactory)battleGroundFactory).setWidth(battleAreaWidth);

        ShipPlacementStrategy placementStrategy = new DefaultPlacementStrategy(xCoordinate,yCoordinate);

        WinnerStrategy winnerStrategy = new DefaultWinnerStrategy();

        BattleGroundAllocationStrategy battleGroundAllocationStrategy= new DefaultBattleGroundAllocationStrategy(battleGroundFactory);

        PlayerInitializer playerInitializer = new TwoPlayerInitializer(types);

        MissileSequenceInitializer missileSequenceInitializer = new TwoPlayerMissileInitializer(sequence);

        ShipCreationStrategy shipCreationStrategy = new EqualShipPerPlayerStrategy(numShips,shipTypes, height, width);

        GameStrategy gameStrategy = new DefaultGameStrategy(new RoundRobinSelectionStrategy(),new DefaultTerminalConditionStrategy());

        BattleShipGame game = BattleShipGameFactory.initializeGame(mode,
                shipCreationStrategy,
                placementStrategy,
                winnerStrategy,
                battleGroundAllocationStrategy,
                playerInitializer,
                missileSequenceInitializer,
                gameStrategy);

        game.initialize();
        game.playGame();
        game.getWinner();

    }
}