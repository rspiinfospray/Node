package org.infospray.node.world.model;

import java.util.ArrayList;
import java.util.List;

public class ViewWorld {

    List<CaseView> listCase = new ArrayList<CaseView>();

    public List<CaseView> getListCase() {
        return this.listCase;
    }

    public void setListCase(final List<CaseView> listCase) {
        this.listCase = listCase;
    }

}
