package com.desiertodigital.orderservice.service;

import com.desiertodigital.orderservice.dto.OrderDto;
import com.desiertodigital.orderservice.dto.OrderDtoFrontEnd;
import com.desiertodigital.orderservice.dto.UserDto;
import com.desiertodigital.orderservice.entity.Order;
import com.desiertodigital.orderservice.mapper.OrderMapper;
import com.desiertodigital.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final SequenceGenerator sequenceGenerator;
    private final RestTemplate restTemplate;

    @Override
    public OrderDto orderSavedInDb(OrderDtoFrontEnd orderDtoFrontEnd) {

        Integer newOrderId = sequenceGenerator.generateNextOrderId();

        UserDto queryUser = this.getUserDetailsFromUserMicroService(orderDtoFrontEnd.getUserId());

        Order orderToBeSaved = new Order(newOrderId,
                                         orderDtoFrontEnd.getFoodItemList(),
                                         orderDtoFrontEnd.getRestaurantDto(),
                                         queryUser);
        //save to order to mongo DB
        orderRepository.save(orderToBeSaved);

        return OrderMapper.INSTANCE.mapOrderToOrderDto(orderToBeSaved);
    }

    /**
     *
     * @param userId
     * @return UserDto
     *
     * This helper method gets the User data by id using DESIERTO-USER-SERVICE microservice.
     */
    private UserDto getUserDetailsFromUserMicroService(Long userId) {
        return restTemplate.getForObject("http://DESIERTO-USER-SERVICE/user/"+userId, UserDto.class);
    }
}
