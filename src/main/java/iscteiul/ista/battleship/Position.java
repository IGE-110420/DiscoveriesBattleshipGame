package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Represents a position (cell) on the Battleship game board.
 *
 * Each position is identified by a row and a column.
 * A position may be occupied by a ship and may be hit during the game.
 *
 * Two positions are considered equal if they have the same row and column.
 *
 * @author TeuNome
 * @version 1.0
 */
public class Position implements IPosition {

    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Creates a new Position with the given row and column.
     *
     * @param row the row of the position
     * @param column the column of the position
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Returns the row of this position.
     *
     * @return the row number
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this position.
     *
     * @return the column number
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Compares this position with another object.
     * Two positions are equal if they have the same row and column.
     *
     * @param otherPosition the object to compare
     * @return true if positions are equal, false otherwise
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;

        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return this.getRow() == other.getRow() &&
                   this.getColumn() == other.getColumn();
        }

        return false;
    }

    /**
     * Returns a hash code value for this position.
     * The hash code is based only on row and column,
     * to remain consistent with equals().
     *
     * @return hash code for this position
     */
    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    /**
     * Checks if this position is adjacent to another position.
     * Positions are considered adjacent if they are at most
     * one row and one column apart.
     *
     * @param other the other position to compare
     * @return true if the positions are adjacent, false otherwise
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return Math.abs(this.getRow() - other.getRow()) <= 1 &&
               Math.abs(this.getColumn() - other.getColumn()) <= 1;
    }

    /**
     * Marks this position as occupied by a ship.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marks this position as having been shot.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Checks if this position is occupied by a ship.
     *
     * @return true if occupied, false otherwise
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Checks if this position has been hit.
     *
     * @return true if the position was shot, false otherwise
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Returns a string representation of this position.
     *
     * @return a string containing row and column
     */
    @Override
    public String toString() {
        return "Row = " + row + ", Column = " + column;
    }
}
