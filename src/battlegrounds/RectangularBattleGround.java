package battlegrounds;

import java.util.ArrayList;

public class RectangularBattleGround extends AbstractBattleGround {

    public int getBattleAreaWidth() {
        return battleAreaWidth;
    }

    public int getBattleAreaHeight() {
        return battleAreaHeight;
    }

    private int battleAreaWidth;
    private int battleAreaHeight;

    public RectangularBattleGround(int height,int width) {
    this.battleAreaHeight = height;
    this.battleAreaWidth = width;
    ships = new ArrayList<>();
    }


    public void setBattleAreaWidth(int battleAreaWidth) throws Exception {
        if(battleAreaWidth>=1 && battleAreaWidth<=9)
            this.battleAreaWidth = battleAreaWidth;
        else {
            throw new Exception("allowed width is between 1 to 9");
        }
    }

    public void setBattleAreaHeight(int battleAreaHeight) throws Exception {
        if(battleAreaHeight>=1 && battleAreaHeight<=26)
            this.battleAreaHeight = battleAreaHeight;
        else {
            throw new Exception("allowed height is between A to Z");
        }
    }

    @Override
    public boolean isValidCoordinate(int xCoordinate, int yCoordinate, int width, int height) {
        return xCoordinate + width - 1 <= battleAreaWidth && height + yCoordinate - 1 <= battleAreaHeight
                && xCoordinate > 0 && yCoordinate > 0;
    }
}
