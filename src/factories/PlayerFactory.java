package factories;

import players.Player;
import players.PlayerType;

public class PlayerFactory {
    public static Player getPlayer(PlayerType type) {
        switch(type) {
            case HUMAN : return new Player();
            case COMPUTER : return new Player();
            default: return new Player();
        }
    }
}
