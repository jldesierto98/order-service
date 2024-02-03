package com.desiertodigital.orderservice.entity;

import com.desiertodigital.orderservice.dto.FoodItemsDto;
import com.desiertodigital.orderservice.dto.RestaurantDto;
import com.desiertodigital.orderservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemsDto> foodItemsDto;
    private RestaurantDto restaurantDto;
    private UserDto userDto;
}
