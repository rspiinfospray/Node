package org.infospray.node.peon.model.priority;

import org.infospray.node.peon.model.Peon;

public class SecurityPrority implements Priority {

    public static Integer ENEMY_DISTANCE = 3;

    @Override
    public boolean isAccomplished(final Peon peon) {
        if (peon.getEnemyDistance() >= ENEMY_DISTANCE) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getLevel() {
        return 2;
    }

    @Override
    public Priority getNextPriority() {
        return new ReproductionPriority();
    }

}
