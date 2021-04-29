package ru.grigan.test_task_survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.grigan.test_task_survey.domain.Answer;
import ru.grigan.test_task_survey.domain.Question;
import ru.grigan.test_task_survey.domain.Survey;
import ru.grigan.test_task_survey.domain.User;
import ru.grigan.test_task_survey.service.AnswerService;
import ru.grigan.test_task_survey.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private final UserService userService;
    private final AnswerService answerService;

    public QuizController(UserService userService, AnswerService answerService) {
        this.userService = userService;
        this.answerService = answerService;
    }

    @GetMapping("{id}")
    public String getQuiz(@PathVariable("id") Survey survey, Model model) {
        User user = new User();
        user = userService.saveUser(user);
        for (Question question : survey.getQuestions()) {
            Answer answer = new Answer();
            answer.setQuestions(question);
            user.addAnswers(answer);
        }
        user.addSurvey(survey);
        model.addAttribute("user", user);
        return "questions";
    }

    @PostMapping("/{id}")
    public String saveAnswer(@PathVariable("id") Long id, @ModelAttribute User user) {
        user.setId(id);
        user.getAnswers().forEach(answer -> {
            answer.setUser(user);
            answerService.saveAnswer(answer);
        });
        userService.saveUser(user);
        return "redirect:/";

    }

}
