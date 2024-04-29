package missile.missileinitilizer;

import players.Player;
import players.visitors.PlayerInitializerVisitor;

public class TwoPlayerMissileInitializer extends AbstractMissileSequenceInitializer {
    final int noOfPlayers = 2;
    public TwoPlayerMissileInitializer(String[] sequence) {
        this.sequence = sequence;
    }
    @Override
    public void initializeMissileSequence(PlayerInitializerVisitor visitor, Player[] players) throws Exception {
            visitor.visit(this,players);
    }
}
