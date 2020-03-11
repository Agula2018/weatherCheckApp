package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.service.ParsingService;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v2/installations/")
public class InstallationsController {

    private final ParsingService parsingService;

    @Autowired
    public InstallationsController(ParsingService parsingService) {
        this.parsingService = parsingService;
    }

    @GetMapping("nearest/")
    public String handleNearestInstallation(@RequestParam("lat") double lat,
                                            @RequestParam("lng") double lng,
                                            @RequestParam("maxDistanceKM") double maxDistanceKM,
                                            @RequestParam("maxResults") int maxResults) throws JsonParseException {
        return "ok";
    }

    @GetMapping("{installationId}/")
    public String handleInstallationId(@PathVariable("installationId") int installationId) throws JsonParseException {
        return "ok";
    }
}
