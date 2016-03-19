package com.wmoussa.gol;

public class GolTestHelper {

    protected static Coordinate createOverpopulatedCellArea(Space space) {
        Coordinate coordinate = Coordinate.random();
        space.add(coordinate);
        coordinate.getSurroundingCoordinates().forEach(space::add);
        return coordinate;
    }

    protected static Coordinate addFirstTickSurvivor(Space space) {
        Coordinate coordinate = Coordinate.random();
        space.add(coordinate);
        coordinate.getSurroundingCoordinates().stream().limit(2).forEach(space::add);
        return coordinate;
    }

    protected static void createHermit(Space space) {
        Coordinate coordinate = Coordinate.random();
        space.add(coordinate);
    }

    protected static Coordinate createGenesisEnvironment(Space space) {
        Coordinate coordinate = Coordinate.random();
        coordinate.getSurroundingCoordinates().stream().limit(3).forEach(space::add);
        return coordinate;
    }

    protected static void applyTwoGenerationSurvivorTopology(Space space) {
        Coordinate coordinate = new Coordinate(0, 0);
        space.add(coordinate);

        coordinate = new Coordinate(-1, 0);
        space.add(coordinate);

        coordinate = new Coordinate(-2, 0);
        space.add(coordinate);

        coordinate = new Coordinate(1, 0);
        space.add(coordinate);

        coordinate = new Coordinate(2, 0);
        space.add(coordinate);

        coordinate = new Coordinate(0, 1);
        space.add(coordinate);

        coordinate = new Coordinate(-1, -1);
        space.add(coordinate);

        coordinate = new Coordinate(1, 1);
        space.add(coordinate);
    }
}
