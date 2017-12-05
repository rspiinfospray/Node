package org.infospray.node.world.model;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Integer nbX;

    private Integer nbY;

    private Integer percentGrass;

    private Integer percentRock;

    private Integer percentWater;

    private Integer percentWood;

    private List<Case> listCase = new ArrayList<Case>();

    public List<Case> getListCase() {
        return this.listCase;
    }

    public void setListCase(final List<Case> listCase) {
        this.listCase = listCase;
    }

    public Integer getNbX() {
        return this.nbX;
    }

    public void setNbX(final Integer nbX) {
        this.nbX = nbX;
    }

    public Integer getNbY() {
        return this.nbY;
    }

    public void setNbY(final Integer nbY) {
        this.nbY = nbY;
    }

    public Integer getPercentGrass() {
        return this.percentGrass;
    }

    public void setPercentGrass(final Integer percentGrass) {
        this.percentGrass = percentGrass;
    }

    public Integer getPercentRock() {
        return this.percentRock;
    }

    public void setPercentRock(final Integer percentRock) {
        this.percentRock = percentRock;
    }

    public Integer getPercentWater() {
        return this.percentWater;
    }

    public void setPercentWater(final Integer percentWater) {
        this.percentWater = percentWater;
    }

    public Integer getPercentWood() {
        return this.percentWood;
    }

    public void setPercentWood(final Integer percentWood) {
        this.percentWood = percentWood;
    }

}
