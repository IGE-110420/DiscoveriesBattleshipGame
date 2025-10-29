package iscteiul.ista.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    void buildShip() {
        Compass c = Compass.values().length > 0 ? Compass.values()[0] : null;
        Position p = new Position(0, 0);
        Ship s = Ship.buildShip("N", c, p);
        assertNull(s);
        s = Ship.buildShip("Galeao", c, p);
        assertNotNull(s);
        assertEquals("Galeao", s.getCategory());
        assertEquals(p, s.getPosition());
        assertEquals(c, s.getBearing());
    }

    @Test
    void getCategory() {
        Ship s = Ship.buildShip("Barca", Compass.charToCompass('e'), new Position(1,1));
        assertEquals("Barca", s.getCategory());
    }

    @Test
    void getPositions() {
        Ship s = Ship.buildShip("Caravela", Compass.charToCompass('e'), new Position(2, 3));
        assertEquals(2, s.getPositions().size());
        assertTrue(s.getPositions().contains(new Position(2, 3)));
        assertTrue(s.getPositions().contains(new Position(2, 4)));
    }

    @Test
    void getPosition() {
        Position p = new Position(5, 5);
        Ship s = Ship.buildShip("Barca", Compass.charToCompass('e'), p);
        assertEquals(p, s.getPosition());
    }

    @Test
    void getBearing() {
        Compass c = Compass.charToCompass('s');
        Ship s = Ship.buildShip("Barca", c, new Position(0,0));
        assertEquals(c, s.getBearing());
    }

    @Test
    void stillFloating() {
        Ship s = Ship.buildShip("Caravela", Compass.charToCompass('e') , new Position(1, 1));
        assertTrue(s.stillFloating());
        s.getPositions().get(0).shoot();
        assertTrue(s.stillFloating());
        s.getPositions().get(1).shoot();
        assertFalse(s.stillFloating());
    }

    @Test
    void getTopMostPos() {
        Ship s = Ship.buildShip("Galeao", Compass.charToCompass('s'), new Position(5, 5));
        assertEquals(5, s.getTopMostPos());
    }

    @Test
    void getBottomMostPos() {
        Ship s = Ship.buildShip("Galeao", Compass.charToCompass('n'), new Position(5, 5));
        assertEquals(7, s.getBottomMostPos());
    }

    @Test
    void getLeftMostPos() {
        Ship s = Ship.buildShip("Galeao", Compass.charToCompass('e'), new Position(5, 5));
        assertEquals(3, s.getLeftMostPos());
    }

    @Test
    void getRightMostPos() {
        Ship s = Ship.buildShip("Galeao", Compass.charToCompass('o'), new Position(5, 5));
        assertEquals(7, s.getRightMostPos());
    }

    @Test
    void occupies() {
        Position p1 = new Position(3, 3);
        Position p2 = new Position(4, 4);
        Ship s = Ship.buildShip("Caravela", Compass.charToCompass('n'), p1);
        assertTrue(s.occupies(p1));
        assertFalse(s.occupies(p2));
    }

    @Test
    void tooCloseTo() {
        Position p1 = new Position(3, 3);
        Position p2 = new Position(4, 4); // adjacent
        Position p3 = new Position(6, 6);  // not adjacent
        Ship s = Ship.buildShip("Nau", Compass.charToCompass('n'), p1);
        assertTrue(s.tooCloseTo(p2));
        assertFalse(s.tooCloseTo(p3));
    }

    @Test
    void testTooCloseTo() {
        Position p1 = new Position(1, 1);
        Position p2 = new Position(1, 2);
        Ship s1 = Ship.buildShip("Barca", Compass.charToCompass('n'), p1);
        Ship s2 = Ship.buildShip("Barca", Compass.charToCompass('n'), p2);
        assertTrue(s1.tooCloseTo(s2));

        Position p3 = new Position(5, 5);
        Ship s3 = Ship.buildShip("Barca", Compass.charToCompass('n'), p3);
        assertFalse(s1.tooCloseTo(s3));
    }

    @Test
    void shoot() {
        Ship s = Ship.buildShip("Fragata", Compass.charToCompass('n'), new Position(2, 2));
        assertFalse(s.getPositions().get(0).isHit());
        s.shoot(s.getPositions().get(0));
        assertTrue(s.getPositions().get(0).isHit());
    }

    @Test
    void testToString() {
        Ship s = Ship.buildShip("Barca", Compass.charToCompass('n'), new Position(1, 1));
        String str = s.toString();
        assertTrue(str.contains("[Barca n Linha = " + s.getPosition().getRow() + " Coluna = " + s.getPosition().getColumn() + "]"));
    }
}