package factories;

import battlegrounds.BattleGround;
import battlegrounds.SquareBattleGround;

public class SquareBattleGroundFactory implements BattleGroundFactory {
    int edgeLength;
    @Override
    public BattleGround createBattleGround() {
        return new SquareBattleGround(edgeLength);
    }
}
