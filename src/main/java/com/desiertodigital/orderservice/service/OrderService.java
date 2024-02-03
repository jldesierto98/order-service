package com.desiertodigital.orderservice.service;

import com.desiertodigital.orderservice.dto.OrderDto;
import com.desiertodigital.orderservice.dto.OrderDtoFrontEnd;

public interface OrderService {

    OrderDto orderSavedInDb(OrderDtoFrontEnd orderDtoFrontEnd);
}
