package com.Bagsy.formulario;

public class Product {
    private String name;
    private int quantity;

    // Construtor padrão (necessário para frameworks como o Spring e Thymeleaf)
    public Product() {
        // Construtor sem parâmetros, usado pelo Spring e Thymeleaf para criação de objetos
    }

    // Construtor com parâmetros
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Getter e Setter para 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Validação (opcional): Verifica se o nome não é vazio ou nulo
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
    }

    // Getter e Setter para 'quantity'
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        // Validação (opcional): Verifica se a quantidade é positiva
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a zero.");
        }
    }

    // Método toString para exibir uma representação do produto (útil para depuração)
    @Override
    public String toString() {
        return "Product{name='" + name + "', quantity=" + quantity + "}";
    }
}
