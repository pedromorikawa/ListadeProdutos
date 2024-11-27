package com.Bagsy.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CadastroController {

    @GetMapping("/cadastro")
    public String showForm(Model model) {
        model.addAttribute("cadastroForm", new CadastroForm());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String processForm(@ModelAttribute("cadastroForm") CadastroForm cadastroForm, Model model) {
        model.addAttribute("nome", cadastroForm.getNome());
        model.addAttribute("email", cadastroForm.getEmail());
        return "cadastro-sucesso";
    }
}

