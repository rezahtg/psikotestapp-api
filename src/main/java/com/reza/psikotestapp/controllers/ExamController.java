package com.reza.psikotestapp.controllers;

import com.reza.psikotestapp.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @RequestMapping("/")
    public String getAllQuestion(Model model){
        model.addAttribute("allQuestions", examService.getAllExam());
        return "index";
    }

}
