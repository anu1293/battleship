package players;

import battlegrounds.BattleGround;
import missile.Missile;
import ships.Ship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private BattleGround battleGround;
    private List<Missile> missileSequence;
    private int remainingShips;
    private List<Ship> ships;

    public Player() {
        this.ships = new ArrayList<>();
        this.missileSequence = new ArrayList<>();
    }

    public BattleGround getBattleGround() {
        return battleGround;
    }

    public void setBattleGround(BattleGround battleGround) {
        this.battleGround = battleGround;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public int getRemainingShips() {
        return remainingShips;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setRemainingShips(int remainingShips) {
        this.remainingShips = remainingShips;
        if(remainingShips==0) {
            setMissileSequence(Collections.emptyList());
        }
    }

    public void updateRemainingShips(int val) {
        this.remainingShips+=val;
    }

    public List<Missile> getMissileSequence() {
        return missileSequence;
    }

    public void setMissileSequence(List<Missile> missileSequence) {
        this.missileSequence = missileSequence;
    }

    public void addShip(Ship ship) {
            this.ships.add(ship);
            updateRemainingShips(1);
        }


    public boolean fireMissile(Missile missile, Player opponent) {
        for (Ship ship : opponent.ships) {
            if (missile.getXCoordinate() >= ship.getxCoordinate() && missile.getXCoordinate() < ship.getxCoordinate() + ship.getWidth() &&
                    missile.getYCoordinate() >= ship.getyCoordinate() && missile.getYCoordinate() < ship.getyCoordinate() + ship.getHeight()) {
                ship.markHit(missile.getXCoordinate(), missile.getYCoordinate());
                if (ship.isDestroyed() && ship.isHit(missile.getXCoordinate(), missile.getYCoordinate())) {
                    opponent.setRemainingShips(opponent.getRemainingShips()-1);
                }
                return ship.isHit(missile.getXCoordinate(), missile.getYCoordinate());
            }
        }
        return false;
    }
}