package missile;

import players.Player;

public class MissileFactory {
    public static Missile createMissile(int x, int y, Player oppenent) {
        return new BasicMissile(x,y,oppenent);
    }
}
