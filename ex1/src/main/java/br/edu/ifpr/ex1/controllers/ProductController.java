package br.edu.ifpr.ex1.controllers;

import br.edu.ifpr.ex1.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
@Controller
@RequestMapping("/produtos")
public class ProductController {
    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @GetMapping("/cadastro")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-cadastro";
    }
    @PostMapping("/salvar")
    public String saveProduct(@ModelAttribute Product product, Model model) throws IOException {

        MultipartFile imagem = product.getImagem();

        if (imagem != null && !imagem.isEmpty()) {
            String fileName = imagem.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.copy(imagem.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            model.addAttribute("imagemPath", "/uploads/" + fileName);
        }

        model.addAttribute("product", product);
        return "sucesso";
    }
}
