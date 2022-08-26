package com.book_library.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long amount;
    private Long totalAmount;

    public Book() {
    }

    public Book(Long id, String name, Long amount, Long totalAmount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.totalAmount = totalAmount;
    }

    public Book(String name, Long amount, Long totalAmount) {
        this.name = name;
        this.amount = amount;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
}
