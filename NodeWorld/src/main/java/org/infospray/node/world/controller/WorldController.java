package org.infospray.node.world.controller;

import javax.validation.Valid;

import org.infospray.node.world.controller.input.BuildWorldInput;
import org.infospray.node.world.model.Case;
import org.infospray.node.world.model.Coord;
import org.infospray.node.world.model.ViewWorld;
import org.infospray.node.world.model.World;
import org.infospray.node.world.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/world")
public class WorldController {

    @Autowired
    WorldService wordService;

    @RequestMapping(path = "build", method = RequestMethod.POST, consumes = "application/json")
    public void build(@RequestBody @Valid final BuildWorldInput buildWorldInput) {
        this.wordService.build(buildWorldInput);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    public World getWorld() {
        return this.wordService.getWorld();
    }

    @RequestMapping(path = "/case/{x}/{y}", method = RequestMethod.GET, produces = "application/json")
    public Case getCase(@PathVariable final Integer x, @PathVariable final Integer y) {
        return this.wordService.getCase(x, y);
    }

    @RequestMapping(path = "/peon/{id}", method = RequestMethod.GET, produces = "application/json")
    public Coord getPeonCoord(@PathVariable final Integer id) {
        return this.wordService.getPeonCoord(id);
    }

    @RequestMapping(path = "/peon/{id}", method = RequestMethod.POST, produces = "application/json")
    public void addPeon(@PathVariable final Integer id, @RequestBody final Coord coord) {
        this.wordService.addPeon(id, coord);
    }

    @RequestMapping(path = "/peon/{id}/look/{viewLevel}", method = RequestMethod.GET, produces = "application/json")
    public ViewWorld peonLook(@PathVariable final Integer id, @PathVariable final Integer viewLevel) {
        return this.wordService.peonLook(id, viewLevel);
    }

}
