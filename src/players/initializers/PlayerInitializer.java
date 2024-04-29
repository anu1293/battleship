package players.initializers;

import players.visitors.PlayerInitializerVisitor;
import players.Player;

public interface PlayerInitializer {
     Player[] initializePlayers(PlayerInitializerVisitor visitor) throws Exception;
}
