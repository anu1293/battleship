package battlegrounds;

import ships.Ship;

import java.util.List;

public abstract class AbstractBattleGround implements BattleGround{

    public abstract boolean isValidCoordinate(int xCoordinate, int yCoordinate, int width, int height);


}
