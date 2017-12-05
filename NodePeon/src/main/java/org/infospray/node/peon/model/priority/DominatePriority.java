package org.infospray.node.peon.model.priority;

import org.infospray.node.peon.model.Peon;

public class DominatePriority implements Priority {

    public static Integer NB_BUILD = 2;

    @Override
    public boolean isAccomplished(final Peon peon) {
        if (peon.getNbBuild() >= NB_BUILD) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getLevel() {
        return 5;
    }

    @Override
    public Priority getNextPriority() {
        return this;
    }

}
