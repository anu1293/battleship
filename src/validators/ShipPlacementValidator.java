package validators;

public interface ShipPlacementValidator {
    boolean isValidPlacement(int x, int y, int width, int height) throws Exception;
}
