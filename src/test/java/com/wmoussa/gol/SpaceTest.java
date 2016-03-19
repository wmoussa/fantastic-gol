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
        createOverpopulatedCellArea(space);

        space = space.tick();

        assertThat("No more survivors", space.size(), is(0));
    }

    @Test
    public void cellSurviving() {
        Space space = Space.createEmpty();
        addFirstTickSurvivor(space);

        space = space.tick();

        assertThat("Coordinate survived", space.size(), is(1));
    }

    @Test
    public void cellGenesis() {
        Space space = Space.createEmpty();
        createGenesisEnvironment(space);

        space = space.tick();

        assertThat("A new cell is born", space.size(), is(1));
    }


    @Test
    public void mixAll() {
        Space space = Space.createEmpty();
        addFirstTickSurvivor(space);
        addFirstTickSurvivor(space);

        createOverpopulatedCellArea(space);
        createGenesisEnvironment(space);
        createHermit(space);

        space = space.tick();

        assertThat("Healthy space", space.size(), is(3));
    }

    @Test
    public void multipleCycles() {
        Space space = Space.createEmpty();
        addFirstTickSurvivor(space);
        addFirstTickSurvivor(space);

        createOverpopulatedCellArea(space);
        createGenesisEnvironment(space);
        createHermit(space);

        space = space.tick();
        space = space.tick();

        assertThat("Space is gone", space.size(), is(0));
    }

    @Test
    public void survivorAfterTwoCycles() {
        Space space = Space.createEmpty();
        applyTwoGenerationSurvivorTopology(space);

        space = space.tick();
        space = space.tick();

        assertThat("The ONE has survived after two cycles", space.size(), is(1));
    }


}
