package org.infospray.node.peon.service;

import org.infospray.node.peon.model.Peon;
import org.infospray.node.peon.model.priority.EatPriority;
import org.infospray.node.peon.model.priority.Priority;
import org.infospray.node.peon.model.view.ViewWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActionService {

    @Value("${world.url}")
    String worldUrl;

    @Autowired
    private RestTemplate restTemplate;

    public void giveAction(final Priority priority, final Peon peon) {
        this.eatProcess(priority, peon);
    }

    public ViewWorld look() {

        ResponseEntity<ViewWorld> response = this.restTemplate.exchange(this.worldUrl + "/peon/{id}/look/{viewLevel}", HttpMethod.GET, null,
            ViewWorld.class);
        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            return null;
        } else {
            return response.getBody();
        }
    }

    public void eatProcess(final Priority priority, final Peon peon) {
        if (priority instanceof EatPriority) {
            ViewWorld viewWorld = this.look();
            if (viewWorld != null) {

            }
        }
    }

}
