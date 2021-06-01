package com.example.assignment.controller;

import com.example.assignment.entity.ProductEntity;
import com.example.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    ProductService productService;

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping({"/list"})
    public String pageableProduct(Model model,  @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "1") int size) {
        List<ProductEntity> products = productService.getAllProduct(PageRequest.of(page, size));
        int totalPage  = productService.getTotalPage(PageRequest.of(page, size));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("products", products);
        return "listpro";
    }

    @GetMapping("/create")
    public String viewAddProduct(Model model) {
        ProductEntity productEntity = new ProductEntity();
        model.addAttribute("model", productEntity);
        return "addpro";
    }

    @PostMapping("/create")
    public String addProduct(@ModelAttribute ProductEntity productEntity, Model model) {
        productService.createProduct(productEntity);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String deleteProduct(Model model, @RequestParam(value = "id", defaultValue = "0") int id) {
        if (id != 0) {
            productService.deleteProduct(id);
        }
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String viewUpdateProduct(Model model, @RequestParam(value = "id", defaultValue = "0") int id) {
        ProductEntity product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "updatepro";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute ProductEntity productEntity, Model model) {
        productService.updateProduct(productEntity);
        return "redirect:/list";
    }

}
