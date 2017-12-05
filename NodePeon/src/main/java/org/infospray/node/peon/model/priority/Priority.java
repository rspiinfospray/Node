package org.infospray.node.peon.model.priority;

import org.infospray.node.peon.model.Peon;

public interface Priority {

    public boolean isAccomplished(Peon peon);

    public Integer getLevel();

    public Priority getNextPriority();

}
