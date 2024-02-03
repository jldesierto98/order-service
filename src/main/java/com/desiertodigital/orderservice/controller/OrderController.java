package com.desiertodigital.orderservice.controller;


import com.desiertodigital.orderservice.dto.OrderDto;
import com.desiertodigital.orderservice.dto.OrderDtoFrontEnd;
import com.desiertodigital.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDtoFrontEnd orderDtoFrontEnd){
        OrderDto order = orderService.orderSavedInDb(orderDtoFrontEnd);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
