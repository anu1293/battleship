package factories;

import battlegrounds.BattleGround;
import battlegrounds.RectangularBattleGround;

public class RectangularBattleGroundFactory implements BattleGroundFactory {

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    int height;
    int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public BattleGround createBattleGround() {
        return new RectangularBattleGround(height,width);
    }
}
