package ru.grigan.test_task_survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.grigan.test_task_survey.domain.Survey;
import ru.grigan.test_task_survey.service.SurveyService;

import java.util.List;

@Controller("/admin")
public class AdminController {
    private final SurveyService service;

    public AdminController(SurveyService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAdminPage(Model model) {
        List<Survey> surveyList = service.getSurveyList();
        model.addAttribute("surveyList", surveyList);
        return "admin";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model) {
        model.addAttribute("survey", new Survey());
        return "surveyEdit";
    }

}
