package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.model.Installations;
import com.agnieszka.piotrowska.weatherCheckApp.model.MeasurementHistory;
import com.agnieszka.piotrowska.weatherCheckApp.service.ParsingService;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class AirlyController {

    private static final Logger logger = Logger.getLogger(AirlyController.class.getName());
    private final String MAIN_URL = "https://airapi.airly.eu/";
    private final ParsingService parsingService;

    @Autowired
    public AirlyController(ParsingService parsingService) {
        this.parsingService = parsingService;
    }

    /**
     * INSTALLATIONS
     * @param lat
     * @param lng
     * @param maxDistanceKM
     * @param maxResults
     * @param model
     * @return
     * @throws JsonParseException
     */

    @RequestMapping("v2/installations/")
    @GetMapping("nearest/")
    public Installations handleNearestInstallation(@RequestParam("lat") double lat,
                                                   @RequestParam("lng") double lng,
                                                   @RequestParam("maxDistanceKM") double maxDistanceKM,
                                                   @RequestParam("maxResults") int maxResults,
                                                   Model model) throws JsonParseException {
        Installations installations = (Installations) parsingService.parse(MAIN_URL);
        logger.info("installation request by: " + lat + lng + maxDistanceKM + maxResults);
        model.addAttribute("installation", installations);
        return installations;
    }

    @GetMapping("/v2/installations/{installationId}")
    public Installations handleInstallationId(@PathVariable("installationId") int installationId,
                                              Model model) throws JsonParseException {
        logger.info("installation request by id: " + installationId);
        Installations installations = (Installations) parsingService.parse(MAIN_URL);
        model.addAttribute("installationId", installations);
        return installations;
    }

    /**
     * MEASUREMENTS
     * @param indexType
     * @param installationId
     * @param model
     * @return
     * @throws JsonParseException
     */

    @GetMapping("/v2/measurements/installation")
    public MeasurementHistory detailedMeasurement(@RequestParam("indexType") String indexType,
                                                  @RequestParam("installationId") int installationId,
                                                  Model model) throws JsonParseException {
        logger.info("detailed measurements for an installation " + indexType + installationId);
        MeasurementHistory measurementHistory = (MeasurementHistory) parsingService.parse(MAIN_URL);
        model.addAttribute("measurementHistory" + measurementHistory);
        return measurementHistory;
    }

    @GetMapping("/v2/measurements/nearest")
    public MeasurementHistory detailedMeasurementNearest(@RequestParam("indexType") String indexType,
                                                         @RequestParam("lat") double lat,
                                                         @RequestParam("lng") double lng,
                                                         @RequestParam("maxDistanceKM") double maxDistanceKM,
                                                         Model model) throws JsonParseException {
        logger.info("detailed measurements for an installation " + indexType + lat + lng + maxDistanceKM);
        MeasurementHistory measurementHistory = (MeasurementHistory) parsingService.parse(MAIN_URL);
        model.addAttribute("measurementHistory" + measurementHistory);
        return measurementHistory;
    }

    @GetMapping("/v2/measurements/point")
    public MeasurementHistory detailedMeasurementPoint(@RequestParam("indexType") String indexType,
                                                       @RequestParam("lat") double lat,
                                                       @RequestParam("lng") double lng,
                                                       Model model) throws JsonParseException {
        logger.info("detailed measurements for an installation " + indexType + lat + lng);
        MeasurementHistory measurementHistory = (MeasurementHistory) parsingService.parse(MAIN_URL);
        model.addAttribute("measurementHistory" + measurementHistory);
        return measurementHistory;

    }
}

