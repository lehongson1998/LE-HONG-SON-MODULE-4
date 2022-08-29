package com.shopping_cart.controller;

import com.shopping_cart.model.Cart;
import com.shopping_cart.service.ICartService;
import com.shopping_cart.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShoppingCartController {
    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") Cart cart,
                           Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("countItemQuantity",
                this.iCartService.countItemQuantity(cart));
        model.addAttribute("countProductQuantity",
                this.iCartService.countProductQuantity(cart));
        model.addAttribute("countTotalPayment",
                this.iCartService.countTotalPayment(cart));

        return "cart";
    }

    @PostMapping(value = "/pay")
    public String pay(@RequestParam Float payInput,
                      Model model) {
        model.addAttribute("totalPayment", payInput);
        return "payment";
    }
}
