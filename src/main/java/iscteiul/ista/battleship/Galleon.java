package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Galleon (Galeão) no jogo Battleship.
 *
 * <p>O Galleon é um navio com tamanho fixo de 5 posições na grelha.
 * A forma do navio depende da orientação ({@link Compass}) fornecida
 * no momento da criação.
 *
 * <p>Responsabilidades principais:
 * <ul>
 *   <li>Definir o tamanho do navio.</li>
 *   <li>Preencher as posições ocupadas no tabuleiro conforme a orientação.</li>
 * </ul>
 *
 * @author <TEU_NOME>
 */
public class Galleon extends Ship {

    /** Tamanho fixo do Galleon. */
    private static final Integer SIZE = 5;

    /** Nome do navio apresentado no jogo. */
    private static final String NAME = "Galeao";

    /**
     * Cria um novo Galleon numa determinada posição e orientação.
     *
     * @param bearing orientação do navio (NORTH, EAST, SOUTH, WEST)
     * @param pos posição inicial do navio na grelha
     * @throws NullPointerException se a orientação for null
     * @throws IllegalArgumentException se a orientação for inválida
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Obtém o tamanho do navio Galleon.
     *
     * @return número de posições ocupadas pelo navio (5)
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche as posições do navio quando orientado a Norte.
     *
     * @param pos posição inicial do navio
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche as posições do navio quando orientado a Sul.
     *
     * @param pos posição inicial do navio
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Preenche as posições do navio quando orientado a Este.
     *
     * @param pos posição inicial do navio
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche as posições do navio quando orientado a Oeste.
     *
     * @param pos posição inicial do navio
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }
}
