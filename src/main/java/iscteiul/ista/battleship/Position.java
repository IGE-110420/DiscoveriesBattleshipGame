package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Represents a position (cell) in the 10x10 game board of the
 * Discoveries Battleship Game.
 *
 * A position is identified by its row and column coordinates and
 * maintains information about whether it is occupied by a ship
 * and whether it has been hit by a shot.
 *
 * This class implements the {@link IPosition} interface.
 */
public class Position implements IPosition {

    /**
     * Row index of the position (0-9).
     */
    private int row;

    /**
     * Column index of the position (0-9).
     */
    private int column;

    /**
     * Indicates whether this position is occupied by a ship.
     */
    private boolean isOccupied;

    /**
     * Indicates whether this position has already been shot.
     */
    private boolean isHit;

    /**
     * Creates a new position with the specified coordinates.
     * Initially, the position is not occupied and has not been hit.
     *
     * @param row    the row index of the position (0-9)
     * @param column the column index of the position (0-9)
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Returns the row index of this position.
     *
     * @return the row coordinate
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Returns the column index of this position.
     *
     * @return the column coordinate
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Generates a hash code for this position.
     *
     * @return a hash code based on row, column, occupation and hit state
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compares this position with another object.
     *
     * Two positions are considered equal if they have the same
     * row and column coordinates.
     *
     * @param otherPosition the object to compare with
     * @return true if both positions have the same coordinates, false otherwise
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Determines whether this position is adjacent to another position.
     *
     * Two positions are considered adjacent if the difference in
     * row and column is at most 1 (including diagonals).
     *
     * @param other the other position to compare with
     * @return true if the positions are adjacent, false otherwise
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1
                && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marks this position as occupied by a ship.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marks this position as hit by a shot.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Indicates whether this position is occupied by a ship.
     *
     * @return true if the position contains part of a ship, false otherwise
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Indicates whether this position has already been hit.
     *
     * @return true if the position has been shot, false otherwise
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Returns a textual representation of this position.
     *
     * @return a string describing the row and column of the position
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }
}
