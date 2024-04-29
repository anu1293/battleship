package players.visitors;

import missile.missileinitilizer.MultiPlayerMissileInitializer;
import missile.missileinitilizer.TwoPlayerMissileInitializer;
import players.Player;
import players.initializers.MultiPlayerInitializer;
import players.initializers.TwoPlayerInitializer;

public interface PlayerInitializerVisitor {
    Player[] visit(TwoPlayerInitializer initializer) throws Exception;
    Player[] visit(MultiPlayerInitializer initializer) throws Exception;

    void visit(TwoPlayerMissileInitializer initializer, Player[] players) throws Exception;
    void visit(MultiPlayerMissileInitializer initializer, Player[] players) throws Exception;
}
