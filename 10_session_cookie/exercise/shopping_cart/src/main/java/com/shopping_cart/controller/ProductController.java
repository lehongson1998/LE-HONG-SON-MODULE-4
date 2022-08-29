package com.shopping_cart.controller;

import com.shopping_cart.model.Cart;
import com.shopping_cart.model.Product;
import com.shopping_cart.service.ICartService;
import com.shopping_cart.service.IProductService;
import com.shopping_cart.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error-404";
        }
        if (action.equals("show")) {
            this.iCartService.addProduct(productOptional.get(), cart);
            return "redirect:/shopping-cart";
        }
        if (action.equals("sub")) {
            this.iCartService.subProduct(productOptional.get(), cart);
            return "redirect:/shopping-cart";
        }
        this.iCartService.addProduct(productOptional.get(), cart);
        return "redirect:/shop";
    }

    @GetMapping(value = "/detail/{id}")
    public String showDetail(@PathVariable Long id,
                             Model model) {
        Optional<Product> productOptional = productService.findById(id);
        model.addAttribute("productObj", productOptional.get());
        return "detail";
    }
}
