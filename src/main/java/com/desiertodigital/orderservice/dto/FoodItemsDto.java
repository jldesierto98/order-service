package com.desiertodigital.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemsDto {
    private Long id;

    private String itemName;

    private String itemDescription;

    private Boolean isVeg;

    private BigDecimal price;

    private Long restaurantId;

    private Integer quantity;
}
