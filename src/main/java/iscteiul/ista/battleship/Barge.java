package iscteiul.ista.battleship;

/**
 * Represents a Barge ship in the Battleship game.
 * <p>
 * A Barge is a ship of size 1, i.e., it occupies a single position on the board.
 * This class extends {@link Ship} and provides the specific size and name for a Barge.
 * </p>
 */
public class Barge extends Ship {
    /** The size of a Barge (number of positions it occupies). */
    private static final Integer SIZE = 1;

    /** The name of the ship. */
    private static final String NAME = "Barca";

    /**
     * Constructs a new Barge with the specified bearing and position.
     *
     * @param bearing the orientation of the barge (see {@link Compass})
     * @param pos     the upper-left position of the barge (see {@link IPosition})
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the size of the barge.
     *
     * @return the size of the barge, which is always 1
     */

}