package com.wmoussa.gol;

public class Simulator {

    public static void main(String[] args) throws InterruptedException {
        Space space = new Space();
        createOverpopulatedCellArea(space);
        do {
            draw(space);
            Thread.sleep(1000);
            space = space.tick();
        } while (space.size() != 0);
    }

    private static void draw(Space space) {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (space.contains(new Coordinate(x, y))) {
                    System.out.print('x');
                    System.out.print("(" + x + "," + y + ")");
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    protected static Coordinate createOverpopulatedCellArea(Space space) {
        Coordinate coordinate = Coordinate.random10();
        space.add(coordinate);
        coordinate.getSurroundingCoordinates().forEach(space::add);
        return coordinate;
    }
}
