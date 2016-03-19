package com.wmoussa.gol;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static com.wmoussa.gol.GenesisRule.lazarusPit;
import static com.wmoussa.gol.SurvivorRule.shouldLive;
import static java.util.stream.Collectors.toSet;

public class Space {
    Set<Coordinate> coordinates = new HashSet<>();

    public static Space createEmpty() {
        return new Space();
    }

    public void add(Coordinate coordinate) {
        coordinates.add(coordinate);
    }

    public Space tick() {
        Set<Coordinate> survivors = findSurvivors();
        survivors.addAll(runGenesis());

        Space space = new Space();
        space.coordinates = survivors;
        return space;
    }

    private Set<Coordinate> findSurvivors() {
        return coordinates.stream()
                .filter(c -> shouldLive(c, this))
                .collect(toSet());
    }

    private Set<Coordinate> runGenesis() {
        return coordinates.stream()
                .map(Coordinate::getSurroundingCoordinates)
                .flatMap(Collection::stream)
                .filter(c -> !coordinates.contains(c))
                .filter(c -> lazarusPit(c, this))
                .collect(toSet());
    }

    public int size() {
        return coordinates.size();
    }

    public boolean contains(Coordinate c) {
        return coordinates.contains(c);
    }
}
