package ships;

import battlegrounds.BattleGround;
import players.Player;
import validators.ShipPlacementValidatorImpl;
import validators.ShipPlacementValidator;

import java.util.ArrayList;
import java.util.List;

public class DefaultPlacementStrategy implements ShipPlacementStrategy {

    int[][] xCoordinate;
    int[][] yCoordinate;

    public DefaultPlacementStrategy(int[][] xCoordinate, int[][] yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public void placeShip(Player[] players) throws Exception {
        if(xCoordinate==null || yCoordinate==null)
            throw new Exception("either x or y coordinates are not initialized");
        if(xCoordinate.length!=yCoordinate.length)
            throw new Exception(" count of x and y coordinates are not equal");

        List<Ship> shipsPlaced = null;

        for(int i=0;i<players.length;i++) {

            List<Ship> ships = players[i].getShips();
            shipsPlaced = new ArrayList<>();

            BattleGround battleGround = players[i].getBattleGround();
            int len = ships.size();
            ShipPlacementValidator validator = new ShipPlacementValidatorImpl(battleGround,shipsPlaced);
            for(int j=0;j<len;j++) {

                int x = xCoordinate[i][j];
                int y= yCoordinate[i][j];

                boolean isValidPlacement = validator.isValidPlacement(x,y,ships.get(j).getWidth(),ships.get(j).getHeight());

                if(isValidPlacement) {
                    ships.get(j).setxCoordinate(x);
                    ships.get(j).setyCoordinate(y);
                    battleGround.addShip(ships.get(i));
                    shipsPlaced.add(ships.get(j));
                }
            }
        }
    }
}
