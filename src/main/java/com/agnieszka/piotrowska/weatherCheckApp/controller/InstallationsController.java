package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.model.Installation;
import com.agnieszka.piotrowska.weatherCheckApp.repository.InstallationsRepository;
import com.agnieszka.piotrowska.weatherCheckApp.service.ParsingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/installations/")
public class InstallationsController {

    private final String MAIN_URL = "https://airapi.airly.eu/";
    private final InstallationsRepository installationsRepository;

    @Autowired
    private final ParsingService parsingService;

    @GetMapping(path = "add-parameter/")
    public String get(Model model){
        Installation installation = (Installation) parsingService.parse(MAIN_URL);
        model.addAttribute("installation", installation);
        return "installations-provideParameters";
    }
}
