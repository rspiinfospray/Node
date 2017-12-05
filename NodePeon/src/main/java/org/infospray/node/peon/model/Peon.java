package org.infospray.node.peon.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class Peon {

    @Value("${server.port}")
    private Integer id;

    private String name;

    private Integer team;

    private Integer viewLevel = 1;

    private Integer priorityLevel = 1;

    private Integer health = 100;

    private Integer xp = 0;

    private List<Integer> listChild = new ArrayList<>();

    private List<Integer> listHelpPeon = new ArrayList<>();

    private Integer nbBuild;

    private Integer enemyDistance;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(final Integer health) {
        this.health = health;
    }

    public Integer getPriorityLevel() {
        return this.priorityLevel;
    }

    public void setPriorityLevel(final Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public List<Integer> getListChild() {
        return this.listChild;
    }

    public void setListChild(final List<Integer> listChild) {
        this.listChild = listChild;
    }

    public List<Integer> getListHelpPeon() {
        return this.listHelpPeon;
    }

    public void setListHelpPeon(final List<Integer> listHelpPeon) {
        this.listHelpPeon = listHelpPeon;
    }

    public Integer getNbBuild() {
        return this.nbBuild;
    }

    public void setNbBuild(final Integer nbBuild) {
        this.nbBuild = nbBuild;
    }

    public Integer getTeam() {
        return this.team;
    }

    public Integer getEnemyDistance() {
        return this.enemyDistance;
    }

    public void setEnemyDistance(final Integer enemyDistance) {
        this.enemyDistance = enemyDistance;
    }

    public void setTeam(final Integer team) {
        this.team = team;
    }

    public Integer getViewLevel() {
        return this.viewLevel;
    }

    public void setViewLevel(final Integer viewLevel) {
        this.viewLevel = viewLevel;
    }

    public Integer getXp() {
        return this.xp;
    }

    public void setXp(final Integer xp) {
        this.xp = xp;
    }

}
