package org.infospray.node.peon.controller;

import org.infospray.node.peon.controller.input.Born;
import org.infospray.node.peon.service.PeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peon")
public class PeonController {

    @Autowired
    PeonService peonService;

    @RequestMapping(path = "/born", method = RequestMethod.POST, produces = "application/json")
    void born(@RequestBody final Born born) {
        this.peonService.born(born);
    }

    @RequestMapping(path = "/live", method = RequestMethod.POST, produces = "application/json")
    void live() {
        this.peonService.live();
    }

}
