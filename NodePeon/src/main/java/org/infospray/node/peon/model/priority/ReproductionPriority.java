package org.infospray.node.peon.model.priority;

import org.infospray.node.peon.model.Peon;

public class ReproductionPriority implements Priority {

    public static Integer NB_CHILD = 2;

    @Override
    public boolean isAccomplished(final Peon peon) {
        if (peon.getListChild().size() >= NB_CHILD) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getLevel() {
        return 3;
    }

    @Override
    public Priority getNextPriority() {
        return new HelpPriority();
    }

}
