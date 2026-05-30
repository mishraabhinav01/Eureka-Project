package com.ecommerce.order.dto;

import jakarta.validation.constraints.*;

public class OrderDTO {

    private int id;

    @NotNull
    private int productId;

    @Min(1)
    private int quantity;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
