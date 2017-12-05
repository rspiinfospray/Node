package org.infospray.node.peon.service;

import org.infospray.node.peon.controller.input.Born;
import org.infospray.node.peon.controller.input.Coord;
import org.infospray.node.peon.model.Peon;
import org.infospray.node.peon.model.priority.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PeonService {

    private Peon peon;

    @Autowired
    private PriorityService priority;

    @Value("${world.url}")
    String worldUrl;

    @Value("${decision.url}")
    String decisionUrl;

    @Autowired
    private RestTemplate restTemplate;

    public void live() {

        // check and determine priority
        Priority priority = this.priority.givePriority(this.peon);
        this.peon.setPriorityLevel(priority.getLevel());

        // 1 check priority
        // decision => action
        // xp service

    }

    public void born(final Born born) {

        if (this.firstStepInWorld(born)) {
            this.live();
        }

    }

    private boolean firstStepInWorld(final Born born) {

        this.peon = new Peon();
        this.peon.setName(born.getName());
        this.peon.setTeam(born.getTeam());
        ResponseEntity<Void> response = this.restTemplate.exchange(this.worldUrl + "/peon/{id}", HttpMethod.POST,
            new HttpEntity<Coord>(born.getCoord()),
            Void.class, born.getId());
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return true;
        }

        return false;
    }

}
