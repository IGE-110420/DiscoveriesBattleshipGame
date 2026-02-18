/**
 *
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fba
 *
 */
public class Game implements IGame {
    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;

    private static final int SHOTS_PER_TURN = 3;


    /**
     * @param fleet
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IGame#fire(battleship.IPosition)
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    // maximo 3 shots por turno
    public void fireTurn(List<IPosition> turnShots) {
        if (turnShots == null || turnShots.size() != SHOTS_PER_TURN) {
            throw new IllegalArgumentException("A turn must contain exactly " + SHOTS_PER_TURN + " shots.");
        }

        for (IPosition pos : turnShots) {
            fire(pos);
        }
    }


    /*
     * (non-Javadoc)
     *
     * @see battleship.IGame#getShots()
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IGame#getRepeatedShots()
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IGame#getInvalidShots()
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IGame#getHits()
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IGame#getSunkShips()
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IGame#getRemainingShips()
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    private boolean validShot(IPosition pos) {
        return pos.getRow() >= 0 && pos.getRow() < Fleet.BOARD_SIZE &&
                pos.getColumn() >= 0 && pos.getColumn() < Fleet.BOARD_SIZE;
    }


    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }


    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }


    /**
     * Prints the board showing valid shots that have been fired
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }


    /**
     * Prints the board showing the fleet
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}
