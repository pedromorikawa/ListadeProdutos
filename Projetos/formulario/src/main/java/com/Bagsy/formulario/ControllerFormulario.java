package com.Bagsy.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerFormulario {

    // Lista de produtos simulada
    private final List<Product> products = new ArrayList<>();

    // Construtor para inicializar alguns produtos
    public ControllerFormulario() {
        // Adicionando produtos de exemplo
        products.add(new Product("Bolsa de ombro Bagsy", 100));
        products.add(new Product("Mala de viagem Bagsy", 150));
        products.add(new Product("Mochila Bagsy", 45));
        products.add(new Product("Shoulder bag Bagsy", 5));
        products.add(new Product("Ecobag Bagsy", 28));
    }

    // Exibe a lista de produtos
    @GetMapping("/ListadeProdutos")
    public String listProducts(Model model) {
        model.addAttribute("products", products);
        return "product-list"; // Nome do template HTML
    }

    // Exclui um produto baseado no índice
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int index) {
        // Verifica se o índice é válido e remove o produto
        if (index >= 0 && index < products.size()) {
            products.remove(index);
        }
        return "redirect:/ListadeProdutos"; // Redireciona para a lista de produtos após a exclusão
    }

    // Exibe o formulário de inclusão de um novo produto
    @GetMapping("/incluir")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product("", 0)); // Cria um objeto Produto vazio para o formulário
        return "product-form"; // Nome do template HTML para incluir o produto
    }

    // Processa a inclusão de um novo produto
    @PostMapping("/incluir")
    public String addProduct(Product product) {
        try {
            // Verifica se o produto tem um nome não vazio e se a quantidade é válida
            if (product != null) {
                product.setName(product.getName()); // Valida o nome do produto
                product.setQuantity(product.getQuantity()); // Valida a quantidade
                products.add(product); // Adiciona o produto à lista
            }
        } catch (IllegalArgumentException e) {
            // Se ocorrer uma exceção de validação, redireciona para o formulário com erro
            return "redirect:/incluir?error=true";
        }
        return "redirect:/ListadeProdutos"; // Redireciona para a lista de produtos
    }

    // Exibe o formulário de edição de um produto
    @GetMapping("/editar/{index}")
    public String showEditProductForm(@PathVariable int index, Model model) {
        if (index >= 0 && index < products.size()) {
            model.addAttribute("product", products.get(index)); // Envia o produto para o formulário
        } else {
            return "redirect:/ListadeProdutos"; // Redireciona caso o índice seja inválido
        }
        return "product-form"; // Nome do template HTML para editar o produto
    }

    // Processa a edição de um produto
    @PostMapping("/editar/{index}")
    public String editProduct(@PathVariable int index, Product product) {
        try {
            if (index >= 0 && index < products.size()) {
                Product existingProduct = products.get(index);
                existingProduct.setName(product.getName()); // Valida o nome
                existingProduct.setQuantity(product.getQuantity()); // Valida a quantidade
            }
        } catch (IllegalArgumentException e) {
            // Se ocorrer uma exceção de validação, redireciona para a lista com erro
            return "redirect:/ListadeProdutos?error=true";
        }
        return "redirect:/ListadeProdutos"; // Redireciona para a lista de produtos
    }
}
