package com.rte.highwaytodevops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("api")
    public AppDetails getAppDetails() {
        return AppDetails.builder()
                .appName("High-way-to-Devops")
                .version("V.1.0.1").build();
    }
}
