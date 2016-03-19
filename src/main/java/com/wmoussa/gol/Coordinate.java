package com.wmoussa.gol;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate random() {
        Random random = new Random();
        return new Coordinate(random.nextInt(), random.nextInt());
    }

    public Set<Coordinate> getSurroundingCoordinates() {
        Set<Coordinate> temp = new HashSet<>();
        temp.add(new Coordinate(this.x - 1, y));
        temp.add(new Coordinate(this.x + 1, y));
        temp.add(new Coordinate(this.x - 1, y + 1));
        temp.add(new Coordinate(this.x, y + 1));
        temp.add(new Coordinate(this.x + 1, y + 1));
        temp.add(new Coordinate(this.x - 1, y - 1));
        temp.add(new Coordinate(this.x, y - 1));
        temp.add(new Coordinate(this.x + 1, y - 1));
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate coordinate = (Coordinate) o;

        if (x != coordinate.x) return false;
        return y == coordinate.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
