package validators;

import ships.Ship;
import java.util.List;

class OverlapChecker implements ShipPlacementHandler {
    private List<Ship> shipsPlaced;
    private ShipPlacementHandler nextHandler;

    public OverlapChecker(List<Ship> shipsPlaced) {
        this.shipsPlaced = shipsPlaced;
    }

    @Override
    public boolean isValidPlacement(int xCoordinate, int yCoordinate, int width, int height) throws Exception {
        // Check for ship overlap
        for(Ship ship: shipsPlaced) {
            if(!(xCoordinate+width-1<xCoordinate ||
                    xCoordinate>ship.getxCoordinate()+ship.getWidth()-1 ||
                    yCoordinate+height-1<ship.getyCoordinate() ||
                    yCoordinate>ship.getyCoordinate()+ship.getHeight()-1)) {
                throw new Exception("coordinates x= "+xCoordinate+" y= "+yCoordinate+"overlaps with already palced ship");
            }
        }
        // If not handled, delegate to the next handler in the chain
        if (nextHandler != null) {
            return nextHandler.isValidPlacement(xCoordinate, yCoordinate, width, height);
        }
        return true;
    }

    @Override
    public void setNextHandler(ShipPlacementHandler handler) {
        this.nextHandler = handler;
    }
}