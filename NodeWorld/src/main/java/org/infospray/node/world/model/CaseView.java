package org.infospray.node.world.model;

public class CaseView extends Case {

    public CaseView(final Integer x, final Integer y) {
        super(x, y);
    }

    private Integer distance;

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(final Integer distance) {
        this.distance = distance;
    }

}
