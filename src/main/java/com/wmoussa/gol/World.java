package com.wmoussa.gol;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class World {
    Set<Cell> cells = new HashSet<>();

    public static World createEmpty() {
        return new World();
    }

    public void add(Cell cell) {
        cells.add(cell);
    }

    public void tick() {
        Set<Cell> survivingCells = cells.stream()
                .filter(c -> Rule.shouldLive(c, this)).collect(toSet());

        Set<Cell> newBorn = cells.stream()
                .map(Cell::getPotentialNeighbors)
                .flatMap(Collection::stream)
                .filter(c -> !this.contains(c))
                .filter(c -> Rule.lazarusPit(c, this)).collect(toSet());

        cells.clear();
        cells.addAll(survivingCells);
        cells.addAll(newBorn);
    }

    public int size() {
        return cells.size();
    }

    public boolean contains(Cell c) {
        return cells.contains(c);
    }
}
