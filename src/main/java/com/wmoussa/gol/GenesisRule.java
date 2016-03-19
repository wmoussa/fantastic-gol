package com.wmoussa.gol;

public final class GenesisRule {

    public static boolean lazarusPit(Coordinate coordinate, Space space) {
        long result = coordinate
                .getSurroundingCoordinates()
                .stream()
                .filter(c -> space.contains(c))
                .count();
        return result == 3;
    }
}
