package com.wmoussa.gol;

import org.junit.Test;

import static com.wmoussa.gol.GolTestHelper.addFirstTickSurvivor;
import static com.wmoussa.gol.GolTestHelper.applyTwoGenerationSurvivorTopology;
import static com.wmoussa.gol.GolTestHelper.createGenesisEnvironment;
import static com.wmoussa.gol.GolTestHelper.createHermit;
import static com.wmoussa.gol.GolTestHelper.createOverpopulatedCellArea;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpaceTest {

    @Test
    public void cellDyingAsIfBySolitude() {
        Space space = Space.createEmpty();
        createHermit(space);

        space = space.tick();

        assertThat("No more survivors", space.size(), is(0));
    }

    @Test
    public void cellDyingAsIfByOverPopulation() {
        Space space = Space.createEmpty();
        Coordinate coordinate = createOverpopulatedCellArea(space);

        space = space.tick();

        assertThat("Middle cell has died", space.contains(coordinate), is(false));
    }

    @Test
    public void cellSurviving() {
        Space space = Space.createEmpty();
        Coordinate survivor = addFirstTickSurvivor(space);

        space = space.tick();

        assertThat("Coordinate survived", space.contains(survivor), is(true));
    }

    @Test
    public void cellGenesis() {
        Space space = Space.createEmpty();
        Coordinate tobeborn = createGenesisEnvironment(space);

        space = space.tick();

        assertThat("A new cell is born", space.contains(tobeborn), is(true));
    }
}
