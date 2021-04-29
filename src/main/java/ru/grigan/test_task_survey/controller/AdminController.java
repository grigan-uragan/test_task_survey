package ru.grigan.test_task_survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.grigan.test_task_survey.domain.Question;
import ru.grigan.test_task_survey.domain.Survey;
import ru.grigan.test_task_survey.service.QuestionService;
import ru.grigan.test_task_survey.service.SurveyService;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final SurveyService service;
    private final QuestionService questionService;

    public AdminController(SurveyService service, QuestionService questionService) {
        this.service = service;
        this.questionService = questionService;
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

    @PostMapping("/addQuestion/{id}")
    public String saveQuestion(@PathVariable("id") Survey survey, @ModelAttribute Question question){
        question.setSurvey(survey);
        question = questionService.addQuestion(question);
        survey.addQuestion(question);
        service.saveSurvey(survey);
        return "redirect:/admin";
    }

    @GetMapping("/addQuestion/{id}")
    public String addQuestion(@PathVariable("id") Survey survey, Model model) {
        Question question = new Question();
        question.setSurvey(survey);
        model.addAttribute("question", question);
        return "questEdit";
    }

    @GetMapping("/questEdit/{id}")
    public String editQuestion(@PathVariable("id") Question question, Model model) {
        model.addAttribute("question", question);
        return "questEdit";
    }

    @GetMapping("/questDelete/{id}")
    public String deleteQuestions(@PathVariable("id") Question question) {
        question.setSurvey(null);
        questionService.deleteQuestion(question);
        return "redirect:/admin";
    }

}
