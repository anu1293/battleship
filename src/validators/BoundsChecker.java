package validators;

import battlegrounds.BattleGround;

class BoundsChecker implements ShipPlacementHandler {
    private BattleGround battleGround;
    private ShipPlacementHandler nextHandler;

    public BoundsChecker(BattleGround battleGround) {
        this.battleGround = battleGround;
    }

    @Override
    public boolean isValidPlacement(int x, int y, int width, int height) throws Exception {
        // Check if ship is within battleground bounds
        if (!battleGround.isValidCoordinate(x,y,width,height)) {
            throw new Exception("coordinates x= "+x+" y= "+y+"are out of bounds");
        }
        // If not handled, delegate to the next handler in the chain
        if (nextHandler != null) {
            return nextHandler.isValidPlacement(x, y, width, height);
        }
        return true;
    }

    @Override
    public void setNextHandler(ShipPlacementHandler handler) {
        this.nextHandler = handler;
    }
}