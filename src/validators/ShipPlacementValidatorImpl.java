package validators;

import battlegrounds.BattleGround;
import ships.Ship;

import java.util.List;

public class ShipPlacementValidatorImpl implements ShipPlacementValidator {
    private ShipPlacementHandler chain;

    public ShipPlacementValidatorImpl(BattleGround battleGround, List<Ship> shipsPlaced) {
        BoundsChecker boundsChecker = new BoundsChecker(battleGround);
        OverlapChecker overlapChecker = new OverlapChecker(shipsPlaced);

        // Set up the chain of responsibility
        boundsChecker.setNextHandler(overlapChecker);

        this.chain = boundsChecker;
    }

    public boolean isValidPlacement(int x, int y, int width, int height) throws Exception {
        // Start validation using the chain of responsibility
        return chain.isValidPlacement(x, y, width, height);
    }
}