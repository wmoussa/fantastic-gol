package com.wmoussa.gol;

public final class Rule {

    public static boolean shouldLive(Cell cell, World world) {
        long result = cell.getPotentialNeighbors().stream().filter(c -> world.contains(c)).count();
        return result == 2 || result == 3;
    }

    public static boolean lazarusPit(Cell cell, World world) {
        long result = cell.getPotentialNeighbors().stream().filter(c -> world.contains(c)).count();
        return result == 3;
    }
}
