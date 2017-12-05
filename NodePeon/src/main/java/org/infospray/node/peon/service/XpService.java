package org.infospray.node.peon.service;

import org.infospray.node.peon.model.ActionTypeEnum;
import org.infospray.node.peon.model.Peon;
import org.springframework.stereotype.Service;

@Service
public class XpService {

    private static Integer VIEW_LEVEL_1 = 0;

    private static Integer VIEW_LEVEL_2 = 50;

    private static Integer VIEW_LEVEL_3 = 100;

    private static Integer VIEW_LEVEL_4 = 300;

    private static Integer VIEW_LEVEL_5 = 500;

    private static Integer VIEW_LEVEL_6 = 1000;

    public void learning(final ActionTypeEnum actionType, final Peon peon) {

        Integer newXp = peon.getXp() + actionType.getXp();
        if (newXp < VIEW_LEVEL_1) {
            peon.setViewLevel(1);
        }
        if (newXp > VIEW_LEVEL_2 && newXp < VIEW_LEVEL_3) {
            peon.setViewLevel(2);
        }
        if (newXp > VIEW_LEVEL_3 && newXp < VIEW_LEVEL_4) {
            peon.setViewLevel(3);
        }
        if (newXp > VIEW_LEVEL_4 && newXp < VIEW_LEVEL_5) {
            peon.setViewLevel(4);
        }
        if (newXp > VIEW_LEVEL_5 && newXp < VIEW_LEVEL_6) {
            peon.setViewLevel(5);
        }
        if (newXp > VIEW_LEVEL_6) {
            peon.setViewLevel(6);
        }

        peon.setXp(newXp);

    }

}
