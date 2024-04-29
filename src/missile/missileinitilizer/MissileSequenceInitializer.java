package missile.missileinitilizer;

import players.Player;
import players.visitors.PlayerInitializerVisitor;

public interface MissileSequenceInitializer {

    void initializeMissileSequence(PlayerInitializerVisitor visitor, Player[] players) throws Exception;
}
