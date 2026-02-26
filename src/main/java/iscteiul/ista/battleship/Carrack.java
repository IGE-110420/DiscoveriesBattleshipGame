package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Carrack (Nau) no jogo Battleship.
 *
 * <p>A Carrack ocupa {@value #SIZE} posições consecutivas na grelha e pode ser
 * colocada na vertical (NORTH/SOUTH) ou na horizontal (EAST/WEST), a partir da
 * posição inicial fornecida.
 *
 * <p>Responsabilidades:
 * <ul>
 *   <li>Definir o tamanho fixo do navio.</li>
 *   <li>Calcular e guardar as posições ocupadas no tabuleiro consoante a orientação.</li>
 * </ul>
 *
 * @author <TEU_NOME>
 */

public class Carrack extends Ship {

    /** Tamanho fixo da Carrack. */
    private static final Integer SIZE = 3;

    /** Nome do navio apresentado no jogo. */
    private static final String NAME = "Nau";

    /**
     * Cria uma nova Carrack numa determinada posição e orientação.
     *
     * <p>Para NORTH/SOUTH, as posições são preenchidas verticalmente (linhas crescentes).
     * Para EAST/WEST, as posições são preenchidas horizontalmente (colunas crescentes).
     *
     * @param bearing orientação do navio (NORTH, EAST, SOUTH, WEST)
     * @param pos posição inicial do navio na grelha
     * @throws NullPointerException se {@code bearing} for {@code null}
     * @throws IllegalArgumentException se a orientação for inválida
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);

        if (bearing == null) {
            throw new NullPointerException("ERROR! invalid bearing for the carrack");
        }

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++) {
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                }
                break;

            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++) {
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                }
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Obtém o tamanho do navio Carrack.
     *
     * @return número de posições ocupadas pelo navio (3)
     */
    public Integer getSize() {
        return Carrack.SIZE;
    }
}