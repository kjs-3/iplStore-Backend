package com.example.ipljerseystore.ordermapper;

import com.example.ipljerseystore.orderdto.OrderItemsResponseDto;
import com.example.ipljerseystore.orderdto.OrderRequestDto;
import com.example.ipljerseystore.orderdto.OrderResponseDto;
import com.example.ipljerseystore.orderentity.Orders;
import com.example.ipljerseystore.orderitemsentity.OrderItems;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderItemsResponseDto itemsetd(OrderItems orderItems){
        OrderItemsResponseDto orderItemsResponseDto=new OrderItemsResponseDto();
        orderItemsResponseDto.setOrderitemsId(orderItems.getOrderitemsId());
        orderItemsResponseDto.setProductId(orderItems.getProducts().getProductId());
        orderItemsResponseDto.setProductName(orderItems.getProducts().getProductName());
        orderItemsResponseDto.setTeamName(orderItems.getProducts().getTeamName());
        orderItemsResponseDto.setCategoryName(orderItems.getProducts().getCategory().getName().name());
        orderItemsResponseDto.setSize(orderItems.getProducts().getProductSize());
        orderItemsResponseDto.setImageUrl(orderItems.getProducts().getProductImage());
        orderItemsResponseDto.setQuantity(orderItems.getQuantity());
        orderItemsResponseDto.setPrice(orderItems.getPrice()); //its not product price each orereditems price
        orderItemsResponseDto.setSubtotal(orderItems.getPrice()*orderItems.getQuantity());
        return orderItemsResponseDto;
    }
    public static OrderResponseDto etd(Orders orders){
        OrderResponseDto orderResponseDto=new OrderResponseDto();
        orderResponseDto.setOrderId(orders.getOrderId());
        orderResponseDto.setUserId(orders.getUsers().getUserId());
        orderResponseDto.setUserName(orders.getUsers().getUserName());
        orderResponseDto.setUserPhone(orders.getUsers().getUserPhno());
        orderResponseDto.setAddressUsername(orders.getAddress().getUsers().getUserName());
        orderResponseDto.setAddressPhno(orders.getAddress().getPhoneNo());
        orderResponseDto.setDoorNo(orders.getAddress().getDoorNo());
        orderResponseDto.setCity(orders.getAddress().getCity());
        orderResponseDto.setState(orders.getAddress().getState());
        orderResponseDto.setPincode(orders.getAddress().getPincode());
        List<OrderItemsResponseDto> ordereditems=orders.getOrderItemsList().stream()
                        .map(OrderMapper::itemsetd)
                                .collect(Collectors.toList());
        orderResponseDto.setOrderItemsResponseDtoList(ordereditems);
        orderResponseDto.setTotalAmount(orders.getTotalAmount());
        orderResponseDto.setStatus(orders.getStatus().name());
        return orderResponseDto;
    }
}
