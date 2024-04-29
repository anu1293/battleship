package missile.missileinitilizer;

import players.Player;
import players.visitors.PlayerInitializerVisitor;

public class MultiPlayerMissileInitializer extends AbstractMissileSequenceInitializer {
    @Override
    public void initializeMissileSequence(PlayerInitializerVisitor visitor, Player[] players) throws Exception {
        visitor.visit(this,players);
    }
}
