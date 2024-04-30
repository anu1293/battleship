package battlegrounds;

import ships.Ship;

import java.util.List;

public abstract class AbstractBattleGround implements BattleGround{
    List<Ship> ships;
    public List<Ship> getShips() {
        return ships;
    }
    public void addShip(Ship ship) {
        this.ships.add(ship);
    }
    public abstract boolean isValidCoordinate(int xCoordinate, int yCoordinate, int width, int height);


}
