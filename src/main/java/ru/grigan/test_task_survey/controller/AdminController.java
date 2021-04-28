package ru.grigan.test_task_survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.grigan.test_task_survey.domain.Survey;
import ru.grigan.test_task_survey.service.SurveyService;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final SurveyService service;

    public AdminController(SurveyService service) {
        this.service = service;
    }

    @GetMapping
    public String getAdminPage(Model model) {
        List<Survey> surveyList = service.getSurveyList();
        model.addAttribute("surveyList", surveyList);
        return "admin";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model) {
        Survey survey = new Survey();
        model.addAttribute("survey", survey);
        return "surveyEdit";
    }

    @PostMapping("/save")
    public String saveSurvey(@ModelAttribute Survey survey) {
        if (survey.getId() == null) {
            survey.setStart(Calendar.getInstance());
        }
        service.saveSurvey(survey);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editSurvey(@PathVariable("id") Survey survey, Model model) {
        model.addAttribute("survey", survey);
        return "surveyEdit";
    }

    @GetMapping("/delete/{id}")
    public String deleteSurvey(@PathVariable("id") Survey survey) {
        service.deleteSurvey(survey);
        return "redirect:/admin";
    }

}
