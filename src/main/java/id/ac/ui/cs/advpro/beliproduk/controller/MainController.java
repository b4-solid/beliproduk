package id.ac.ui.cs.advpro.beliproduk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({""})
public class MainController {
    @GetMapping({""})
    public String tempPage() {
        return "tempPage";
    }
}
