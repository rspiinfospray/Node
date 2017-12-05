package org.infospray.node.peon.model;

public enum ActionTypeEnum {

    EAT(100),

    LOOK(5),

    // 1 case = 10
    MOVE(10),

    // 1 gosse
    CHILD(200),

    // peon help
    PEON_HELP(150),

    // build something
    BUILD(300),

    // build something
    KILL(200);

    ActionTypeEnum(final Integer xp) {
        this.xp = xp;
    }

    private Integer xp;

    public Integer getXp() {
        return this.xp;
    }

}
