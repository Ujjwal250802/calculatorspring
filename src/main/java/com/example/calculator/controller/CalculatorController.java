package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double num1,
                            @RequestParam double num2,
                            @RequestParam String operator,
                            Model model) {
        double result = calculatorService.calculate(num1, num2, operator);
        model.addAttribute("result", result);
        return "index";
    }
}
