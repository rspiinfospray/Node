package org.infospray.node.peon.service;

import org.infospray.node.peon.model.Peon;
import org.infospray.node.peon.model.priority.EatPriority;
import org.infospray.node.peon.model.priority.Priority;
import org.springframework.stereotype.Service;

@Service
public class PriorityService {

    public Priority givePriority(final Peon peon) {
        Priority priority = this.getPriorityByLevel(peon.getPriorityLevel());

        if (priority.isAccomplished(peon)) {
            return priority.getNextPriority();
        } else {
            return priority;
        }
    }

    public Priority getPriorityByLevel(final Integer level) {

        Priority priorityChain = new EatPriority();

        while (priorityChain.getLevel() != level) {
            priorityChain.getNextPriority();
        }

        return priorityChain;
    }
}
