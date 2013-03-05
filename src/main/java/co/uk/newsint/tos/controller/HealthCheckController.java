package co.uk.newsint.tos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckController {

    @RequestMapping("/health-check")
    @ResponseBody
    public String health() {
        return "Transaction Orchestration System is ALIVE";
    }

}
