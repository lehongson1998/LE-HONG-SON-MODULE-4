package com.products.controller;

import com.products.model.Product;
import com.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String listProduct(Model model) {
        model.addAttribute("productList", this.iProductService.displayAll());
        return "/product/list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/add-new-product")
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        this.iProductService.createNewProduct(product);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam int id, Model model){
        Product product = this.iProductService.findProduct(id);
        model.addAttribute("product", product);
        return "/product/edit";
    }

    @PostMapping("/edit-product")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        this.iProductService.editProduct(product);
        redirectAttributes.addFlashAttribute("message", "edit successfully");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id){
        this.iProductService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/info-product")
    public String infoProduct(@RequestParam int id, Model model){
        Product product = this.iProductService.findProduct(id);
        model.addAttribute("product",product);
        return "/product/info";
    }

    @PostMapping("/search-by-name")
    public String searchByName(@RequestParam String name, Model model){
        model.addAttribute("productList", this.iProductService.findProductByName(name));
        return "/product/list";
    }
}
