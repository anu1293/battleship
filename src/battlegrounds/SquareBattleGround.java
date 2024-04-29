package battlegrounds;

public class SquareBattleGround extends RectangularBattleGround{

    public SquareBattleGround(int edgeLength) {
        super(edgeLength, edgeLength);
    }

    public int getEdgeLength() {
        return getBattleAreaHeight();
    }
}
