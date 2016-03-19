package com.wmoussa.gol;

public final class SurvivorRule {

    public static boolean shouldLive(Coordinate coordinate, Space space) {
        long result = coordinate
                .getSurroundingCoordinates()
                .stream()
                .filter(c -> space.contains(c))
                .count();
        return result == 2 || result == 3;
    }
}
