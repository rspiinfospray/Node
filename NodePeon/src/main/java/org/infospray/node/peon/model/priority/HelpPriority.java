package org.infospray.node.peon.model.priority;

import org.infospray.node.peon.model.Peon;

public class HelpPriority implements Priority {

    public static Integer NB_PEON_HELP = 3;

    @Override
    public boolean isAccomplished(final Peon peon) {
        if (peon.getListHelpPeon().size() >= NB_PEON_HELP) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getLevel() {
        return 4;
    }

    @Override
    public Priority getNextPriority() {
        return new DominatePriority();
    }

}
