package org.infospray.node.peon.model.priority;

import org.infospray.node.peon.model.Peon;

public class EatPriority implements Priority {

    public static Integer HEALTH = 100;

    @Override
    public boolean isAccomplished(final Peon peon) {
        if (peon.getHealth() >= HEALTH) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getLevel() {
        return 1;
    }

    @Override
    public Priority getNextPriority() {
        return new SecurityPrority();
    }

}
