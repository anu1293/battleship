package battlegrounds;

import factories.BattleGroundFactory;
import players.Player;

public class DefaultBattleGroundAllocationStrategy implements BattleGroundAllocationStrategy {
    BattleGroundFactory factory;

    public DefaultBattleGroundAllocationStrategy(BattleGroundFactory factory) {
        this.factory = factory;
    }

    @Override
    public void initializeBattleGround(Player[] players) {
        for(Player player: players)
            player.setBattleGround(factory.createBattleGround());
    }
}
