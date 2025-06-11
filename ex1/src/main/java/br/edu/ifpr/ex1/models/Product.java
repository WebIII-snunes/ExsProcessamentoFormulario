package br.edu.ifpr.ex1.models;

import org.springframework.web.multipart.MultipartFile;
public class Product {
    private String nome;
    private String categoria;
    private Double preco;
    private String cor;
    private MultipartFile imagem;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public MultipartFile getImagem() { return imagem; }
    public void setImagem(MultipartFile imagem) { this.imagem = imagem; }
}