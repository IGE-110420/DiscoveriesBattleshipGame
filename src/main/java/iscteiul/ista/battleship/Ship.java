package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract representation of a ship in the Discoveries Battleship Game.
 *
 * A ship has:
 * - a category (type of ship),,
 * - a bearing (orientation),
 * - an initial position,
 * - a list of board positions that it occupies.
 *
 * Concrete ship types (Barge, Caravel, Carrack, Frigate, Galleon)
 * extend this class and define their specific size.
 *
 * A ship is considered floating while at least one of its positions
 * has not been hit.
 *
 * @author TeuNome
 * @version 1.0
 */
public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Factory method that creates a concrete Ship instance
     * based on the given ship type.
     *
     * @param shipKind the type/category of the ship
     * @param bearing the orientation of the ship
     * @param pos the initial position of the ship
     * @return a concrete Ship instance or null if the type is invalid
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }

    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;

    /**
     * Constructs a Ship with a given category, orientation and starting position.
     *
     * @param category the ship category
     * @param bearing the orientation of the ship
     * @param pos the starting position of the ship
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Returns the category (type) of the ship.
     *
     * @return the ship category
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Returns the list of board positions occupied by this ship.
     *
     * @return list of occupied positions
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Returns the initial position of the ship.
     *
     * @return the starting position
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Returns the orientation (bearing) of the ship.
     *
     * @return the ship bearing
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Checks whether the ship is still floating.
     * A ship is floating if at least one of its positions
     * has not been hit.
     *
     * @return true if the ship is still floating, false otherwise
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Returns the smallest row value occupied by this ship.
     *
     * @return the topmost row
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Returns the largest row value occupied by this ship.
     *
     * @return the bottommost row
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Returns the smallest column value occupied by this ship.
     *
     * @return the leftmost column
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Returns the largest column value occupied by this ship.
     *
     * @return the rightmost column
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Checks if this ship occupies a given position.
     *
     * @param pos the position to check
     * @return true if the ship occupies that position, false otherwise
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Checks whether this ship is too close to another ship.
     * Ships are considered too close if any of their positions
     * are adjacent.
     *
     * @param other the other ship
     * @return true if ships are too close, false otherwise
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Checks whether this ship is too close to a given position.
     *
     * @param pos the position to check
     * @return true if any part of the ship is adjacent to the position
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }

    /**
     * Registers a shot at a given position.
     * If the ship occupies that position, it will be marked as hit.
     *
     * @param pos the position being shot
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }

    /**
     * Returns a string representation of the ship.
     *
     * @return formatted string containing category, bearing and position
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }
}