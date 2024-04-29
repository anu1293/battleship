package validators;

interface ShipPlacementHandler {
    boolean isValidPlacement(int x, int y, int width, int height) throws Exception;
    void setNextHandler(ShipPlacementHandler handler);
}