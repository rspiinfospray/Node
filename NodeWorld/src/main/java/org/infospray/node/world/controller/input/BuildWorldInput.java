package org.infospray.node.world.controller.input;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BuildWorldInput {

    @NotNull
    @Max(value = 1000)
    @Min(value = 1)
    private Integer nbX;

    @NotNull
    @Max(value = 1000)
    @Min(value = 1)
    private Integer nbY;

    @NotNull
    @Max(value = 100)
    @Min(value = 0)
    private Integer percentGrass;

    @NotNull
    @Max(value = 100)
    @Min(value = 0)
    private Integer percentRock;

    @NotNull
    @Max(value = 100)
    @Min(value = 0)
    private Integer percentWater;

    @NotNull
    @Max(value = 100)
    @Min(value = 0)
    private Integer percentWood;

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

    @AssertTrue(message = "Bad percentage repartition")
    private boolean isGoodPercentRepartition() {

        Integer total = this.percentGrass + this.percentRock + this.percentWater + this.percentWood;
        if (total > 100) {
            return false;
        }
        return true;
    }

}
