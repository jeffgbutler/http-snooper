package com.example.http_snooper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {
    @GetMapping("/redirect")
    public RedirectView redirect(RedirectAttributes redirectAttributes) {
        return new RedirectView("/");
    }

    @GetMapping("/redirector")
    public String redirector() {
        return "redirector";
    }
}
