package com.wmoussa.gol;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Cell gimmeOne() {
        Random random = new Random();
        return new Cell(random.nextInt(), random.nextInt());
    }

    public Set<Cell> getPotentialNeighbors() {
        Set<Cell> temp = new HashSet<Cell>();
        for (int i = this.x - 1; i <= this.x + 1; i++) {
            for (int j = this.y - 1; j <= this.y + 1; j++) {
                if (i != this.x && j != this.y) {
                    temp.add(new Cell(i, j));
                }
            }
        }
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
