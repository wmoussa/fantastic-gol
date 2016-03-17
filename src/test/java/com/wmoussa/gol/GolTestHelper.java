package com.wmoussa.gol;

public class GolTestHelper {

    protected static void createOverpopulatedCellArea(World world) {
        Cell cell = Cell.gimmeOne();
        world.add(cell);
        cell.getPotentialNeighbors().forEach(world::add);
    }

    protected static void addFirstTickSurvivor(World world) {
        Cell cell = Cell.gimmeOne();
        world.add(cell);
        cell.getPotentialNeighbors().stream().limit(2).forEach(world::add);
    }

    protected static void createHermit(World world) {
        Cell cell = Cell.gimmeOne();
        world.add(cell);
    }

    protected static void createGenesisEnvironment(World world) {
        Cell cell = Cell.gimmeOne();
        cell.getPotentialNeighbors().stream().limit(3).forEach(world::add);
    }

    protected static void applyTwoGenerationSurvivorTopology(World world) {
        Cell cell = new Cell(0, 0);
        world.add(cell);

        cell = new Cell(-1, 0);
        world.add(cell);

        cell = new Cell(-2, 0);
        world.add(cell);

        cell = new Cell(1, 0);
        world.add(cell);

        cell = new Cell(2, 0);
        world.add(cell);

        cell = new Cell(0, 1);
        world.add(cell);

        cell = new Cell(-1, -1);
        world.add(cell);

        cell = new Cell(1, 1);
        world.add(cell);
    }
}
