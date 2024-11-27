package com.Bagsy.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    // Rota GET para exibir o formulário de login
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        // Adiciona um objeto User vazio ao modelo para ser utilizado no formulário
        model.addAttribute("user", new User());
        return "login"; // Nome do template HTML (login.html)
    }

    // Rota POST para processar o login
    @PostMapping("/login")
    public String processLogin(@ModelAttribute User user, Model model) {
        // Aqui você pode validar as credenciais do usuário
        // Exemplo de validação simples (você deve substituir com lógica real de autenticação)
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            // Usuário autenticado, redireciona para a página principal ou dashboard
            return "redirect:/dashboard";
        } else {
            // Caso as credenciais sejam inválidas, mostra uma mensagem de erro
            model.addAttribute("error", "Usuário ou senha inválidos");
            return "login";
        }
    }
}

