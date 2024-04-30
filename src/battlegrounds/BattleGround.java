package battlegrounds;

import ships.Ship;
import java.util.List;

public interface BattleGround {
    boolean isValidCoordinate(int xCoordinate, int yCoordinate, int width, int height);
    public List<Ship> getShips();

    public void addShip(Ship ship);
}
