package org.infospray.node.peon.model.view;

import java.util.List;

public class Case {

    Integer x;

    Integer y;

    TypeCaseEnum typeCase;

    TypeFoodEnum typeFood;

    List<Integer> listPeon;

    public Case(final Integer x, final Integer y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public void setX(final Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(final Integer y) {
        this.y = y;
    }

    public TypeCaseEnum getTypeCase() {
        return this.typeCase;
    }

    public void setTypeCase(final TypeCaseEnum typeCase) {
        this.typeCase = typeCase;
    }

    public TypeFoodEnum getTypeFood() {
        return this.typeFood;
    }

    public void setTypeFood(final TypeFoodEnum typeFood) {
        this.typeFood = typeFood;
    }

    public List<Integer> getListPeon() {
        return this.listPeon;
    }

    public void setListPeon(final List<Integer> listPeon) {
        this.listPeon = listPeon;
    }

}
