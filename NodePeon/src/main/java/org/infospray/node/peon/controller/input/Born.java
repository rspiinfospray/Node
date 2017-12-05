package org.infospray.node.peon.controller.input;

public class Born {

    private Integer id;

    private Coord coord;

    private Integer team;

    private String name;

    public Integer getTeam() {
        return this.team;
    }

    public void setTeam(final Integer team) {
        this.team = team;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public void setCoord(final Coord coord) {
        this.coord = coord;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

}
