package com.Bagsy.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerFormulario {

    private final List<Product> products = new ArrayList<>();

    public ControllerFormulario() {
        products.add(new Product("Bolsa de ombro Bagsy", 100));
        products.add(new Product("Mala de viagem Bagsy", 150));
        products.add(new Product("Mochila Bagsy", 45));
        products.add(new Product("Shoulder bag Bagsy", 5));
        products.add(new Product("Ecobag Bagsy", 28));
    }

    @GetMapping("/ListadeProdutos")
    public String listProducts(Model model) {
        model.addAttribute("products", products);
        return "product-list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int index) {
        if (index >= 0 && index < products.size()) {
            products.remove(index);
        }
        return "redirect:/";
    }
}
