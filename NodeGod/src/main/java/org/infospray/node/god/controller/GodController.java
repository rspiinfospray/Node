package org.infospray.node.god.controller;

import java.io.IOException;

import org.infospray.node.god.model.Born;
import org.infospray.node.god.model.BuildWorldInput;
import org.infospray.node.god.model.Coord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/god")
public class GodController {

    @Autowired
    private RestTemplate restTemplate;

    private final static String NODE_WORLD_JAVA_SOURCE_PATH = "C://XXXX//NodeWorld/target/*.java";

    private final static String NODE_PEON_JAVA_SOURCE_PATH = "C://XXXX//NodePeon/target/*.java";

    private final static Integer DEFAULT_X_WORLD = 40;

    private final static Integer DEFAULT_Y_WORLD = 40;

    @Value("${world.url}")
    String worldUrl;

    @Value("${peon.url}")
    String peonUrl;

    @Value("${peon.first.port}")
    String peonFirstPort;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    void bigBang() {

        int nbPeon = 5;
        if (this.buildWorld()) {

            for (int cpt = 0; cpt != nbPeon; cpt++) {
                this.buildPeon(Integer.valueOf(this.peonFirstPort) + cpt);
            }
        }
    }

    private boolean buildWorld() {

        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(
                new String[] { "C://maven//bin/mvn.cmd", "package", "-o", "-f",
                    "C://XXXX//NodeWorld" });

            runtime.exec(
                new String[] { "java", "-jar", NODE_WORLD_JAVA_SOURCE_PATH });
        } catch (IOException e) {
            System.out.println(e);
        }

        BuildWorldInput world = new BuildWorldInput();
        world.setNbX(DEFAULT_X_WORLD);
        world.setNbY(DEFAULT_Y_WORLD);

        // mvn package && java -jar target/gs-spring-boot-0.1.0.jar
        ResponseEntity<Void> response = this.restTemplate.exchange(this.worldUrl + "/build", HttpMethod.POST,
            new HttpEntity<BuildWorldInput>(world),
            Void.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return true;
        }
        return false;
    }

    private boolean buildPeon(final Integer port) {

        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(
                new String[] { "C://maven//bin/mvn", "package", "-o", "-f", "C://XXXX//NodePeon" });

            runtime.exec(
                new String[] { "java", "-jar", NODE_PEON_JAVA_SOURCE_PATH,
                    "--server.port=" + port + "" });
        } catch (IOException e) {

        }

        try {
            Thread.sleep(100000l);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Born born = new Born();
        born.setCoord(new Coord(4, 6));
        born.setId(port);
        born.setName("toto");
        born.setTeam(1);

        ResponseEntity<Void> response = this.restTemplate.exchange(this.peonUrl + "/born",
            HttpMethod.POST,
            new HttpEntity<Born>(born),
            Void.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return true;
        }
        return false;
    }

}
