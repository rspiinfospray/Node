package org.infospray.node.world.service;

import java.util.ArrayList;
import java.util.List;

import org.infospray.node.world.controller.input.BuildWorldInput;
import org.infospray.node.world.model.Case;
import org.infospray.node.world.model.CaseView;
import org.infospray.node.world.model.Coord;
import org.infospray.node.world.model.TypeCaseEnum;
import org.infospray.node.world.model.ViewWorld;
import org.infospray.node.world.model.World;
import org.springframework.stereotype.Service;

@Service
public class WorldService {

    private World world = new World();

    public void build(final BuildWorldInput build) {

        for (int i = 0; i != build.getNbX(); i++) {

            for (int j = 0; j != build.getNbY(); j++) {
                Case lCase = new Case(i, j);
                lCase.setTypeCase(TypeCaseEnum.GRASS);
                this.world.getListCase().add(lCase);
            }
        }

    }

    public World getWorld() {
        return this.world;
    }

    public void setWorld(final World world) {
        this.world = world;
    }

    public Case getCase(final Integer x, final Integer y) {

        for (Case currentCase : this.world.getListCase()) {
            if (currentCase.getX().equals(x) && currentCase.getY().equals(y)) {
                return currentCase;
            }
        }
        return null;
    }

    public Coord getPeonCoord(final Integer id) {
        for (Case currentCase : this.world.getListCase()) {

            List<Integer> listPeon = currentCase.getListPeon();

            for (Integer currentIdPeon : listPeon) {
                if (currentIdPeon.equals(id)) {
                    return new Coord(currentCase.getX(), currentCase.getY());
                }
            }
        }
        return null;
    }

    public void addPeon(final Integer id, final Coord coord) {
        this.getCase(coord.getX(), coord.getY()).getListPeon().add(id);
    }

    public ViewWorld peonLook(final Integer id, final Integer viewLevel) {

        ViewWorld viewWorld = new ViewWorld();
        Coord coordPeon = this.getPeonCoord(id);
        if (null != coordPeon) {
            Case peonCase = this.getCase(coordPeon.getX(), coordPeon.getX());
            CaseView viewCasePeon = (CaseView) peonCase;
            viewWorld.getListCase().add(viewCasePeon);

            Integer x = peonCase.getX();
            Integer y = peonCase.getY();

            List<Coord> levelCoord = new ArrayList<>();

            for (int i = 0; i <= viewLevel; i++) {

                for (int j = 0; j <= viewLevel; j++) {
                    levelCoord.add(new Coord(x - i, y - j));
                    levelCoord.add(new Coord(x + i, y - j));
                    levelCoord.add(new Coord(x - i, y + j));
                    levelCoord.add(new Coord(x + i, y + j));
                }

            }

            for (Coord coord : levelCoord) {
                Case foundCase = this.getCase(coord.getX(), coord.getY());

                if (foundCase != null) {
                    CaseView foundCaseView = (CaseView) peonCase;
                    Integer diffX = coord.getX() - x;
                    diffX = Math.abs(diffX);
                    Integer diffY = coord.getY() - y;
                    diffY = Math.abs(diffY);
                    if (diffX >= diffY) {
                        foundCaseView.setDistance(diffX);
                    } else {
                        foundCaseView.setDistance(diffY);
                    }
                    viewWorld.getListCase().add(foundCaseView);
                }
            }
        }

        return viewWorld;
    }

}
