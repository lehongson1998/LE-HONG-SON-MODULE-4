package com.productmanagement.controller;

import com.productmanagement.model.Product;
import com.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String listProduct(Model model,
                              @RequestParam Optional<String> name,
                              @PageableDefault(size = 4)Pageable pageable) {
        String keyName = name.orElse("");
        model.addAttribute("productList", this.iProductService.displayAll(keyName, pageable));
        model.addAttribute("keyName", keyName);
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
    public String showFormEdit(@RequestParam Long id, Model model){
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
    public String deleteProduct(@RequestParam Long id){
        this.iProductService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/info-product")
    public String infoProduct(@RequestParam Long id, Model model){
        Product product = this.iProductService.findProduct(id);
        model.addAttribute("product",product);
        return "/product/info";
    }
}
