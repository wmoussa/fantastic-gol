package com.wmoussa.gol;

import org.junit.Test;

import static com.wmoussa.gol.GolTestHelper.addFirstTickSurvivor;
import static com.wmoussa.gol.GolTestHelper.applyTwoGenerationSurvivorTopology;
import static com.wmoussa.gol.GolTestHelper.createGenesisEnvironment;
import static com.wmoussa.gol.GolTestHelper.createHermit;
import static com.wmoussa.gol.GolTestHelper.createOverpopulatedCellArea;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WorldTest {

    @Test
    public void cellDyingAsIfBySolitude() {
        World world = World.createEmpty();
        createHermit(world);

        world.tick();

        assertThat("No more survivors", world.size(), is(0));
    }

    @Test
    public void cellDyingAsIfByOverPopulation() {
        World world = World.createEmpty();
        createOverpopulatedCellArea(world);

        world.tick();

        assertThat("No more survivors", world.size(), is(0));
    }

    @Test
    public void cellSurviving() {
        World world = World.createEmpty();
        addFirstTickSurvivor(world);

        world.tick();

        assertThat("Cell survived", world.size(), is(1));
    }

    @Test
    public void cellGenesis() {
        World world = World.createEmpty();
        createGenesisEnvironment(world);

        world.tick();

        assertThat("A new cell is born", world.size(), is(1));
    }


    @Test
    public void mixAll() {
        World world = World.createEmpty();
        addFirstTickSurvivor(world);
        addFirstTickSurvivor(world);

        createOverpopulatedCellArea(world);
        createGenesisEnvironment(world);
        createHermit(world);

        world.tick();

        assertThat("Healthy world", world.size(), is(3));
    }

    @Test
    public void multipleCycles() {
        World world = World.createEmpty();
        addFirstTickSurvivor(world);
        addFirstTickSurvivor(world);

        createOverpopulatedCellArea(world);
        createGenesisEnvironment(world);
        createHermit(world);

        world.tick();
        world.tick();

        assertThat("World is gone", world.size(), is(0));
    }

    @Test
    public void survivorAfterTwoCycles() {
        World world = World.createEmpty();
        applyTwoGenerationSurvivorTopology(world);

        world.tick();
        world.tick();

        assertThat("The ONE has survived after two cycles", world.size(), is(1));
    }


}
