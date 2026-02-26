package iscteiul.ista.battleship;

/**
 * Represents a Caravel ship in the Battleship game.
 * <p>
 * A Caravel has a fixed size of 2 positions and can be placed
 * horizontally or vertically on the board depending on its bearing.
 * </p>
 * 
 * The occupied positions are calculated based on the initial position
 * and the specified bearing.
 * 
 * @author 
 */
public class Caravel extends Ship {

    /** Fixed size of the Caravel ship. */
    private static final Integer SIZE = 2;

    /** Display name of the ship. */
    private static final String NAME = "Caravela";

    /**
     * Constructs a Caravel with a given bearing and starting position.
     *
     * @param bearing the direction in which the ship is placed
     *                (NORTH, SOUTH, EAST or WEST)
     * @param pos the initial position (starting cell) of the ship
     *
     * @throws NullPointerException if bearing is null
     * @throws IllegalArgumentException if bearing is invalid
     */
    public Caravel(Compass bearing, IPosition pos)
            throws NullPointerException, IllegalArgumentException {

        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(
                        new Position(pos.getRow() + r, pos.getColumn())
                    );
                break;

            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(
                        new Position(pos.getRow(), pos.getColumn() + c)
                    );
                break;

            default:
                throw new IllegalArgumentException(
                    "ERROR! invalid bearing for the caravel"
                );
        }
    }

    /**
     * Returns the size of the Caravel.
     *
     * @return the fixed size (2)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
