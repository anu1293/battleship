package factories;

import battlegrounds.BattleGroundType;

public class BattleGroundFactoryOfFactories {
    public static BattleGroundFactory getBattleGroundFactory(BattleGroundType type) {
        return switch(type) {
            case RECTANGULAR ->  new RectangularBattleGroundFactory();
            case SQUARE ->  new SquareBattleGroundFactory();
        };
    }
}
