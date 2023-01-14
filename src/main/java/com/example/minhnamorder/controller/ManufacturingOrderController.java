package com.example.minhnamorder.controller;

import com.example.minhnamorder.model.ManufacturingOrder;
import com.example.minhnamorder.model.OrderDto;
import com.example.minhnamorder.model.OrderQuantity;
import com.example.minhnamorder.model.ProductOrderDto;
import com.example.minhnamorder.repository.ManufracturingOrderRepository;
import com.example.minhnamorder.repository.OrderQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class ManufacturingOrderController {
    @Autowired
    private ManufracturingOrderRepository manufracturingOrderRepository;

    @Autowired
    private OrderQuantityRepository orderQuantityRepository;

    @GetMapping(value = "/order/{id}")
    public ResponseEntity<?> getEntity(@PathVariable(value = "id") Long id) {
        ManufacturingOrder order = manufracturingOrderRepository.findById(id).orElse(null);
        if(order == null)
            return ResponseEntity.ok("NULL");
        return ResponseEntity.ok(toOrderDTO(order));
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<?> getEntitys() {
        return ResponseEntity.ok(manufracturingOrderRepository.findAll()
                .stream()
                .map(order -> toOrderDTO(order))
                .collect(Collectors.toList()));
    }

    public OrderDto toOrderDTO(ManufacturingOrder order){
        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .clientName(order.getClientName())
                .deliverDate(order.getDeliverDate())
                .dateStart(order.getDateStart())
                .dateExpect(order.getDateExpect())
                .build();

        orderDto.setProductList(order.getProductList().stream().map(p -> {

            return ProductOrderDto.fromProduct(p,
                    orderQuantityRepository.findByOrderIDAndProductCode(order.getId(), p.getCode()).get(0).getQuantity());
        }).collect(Collectors.toList()));
        return orderDto;
    }

    @PostMapping(value = "/order")
    public ResponseEntity<?> postEntity(@RequestBody OrderDto order) {
        ManufacturingOrder response = manufracturingOrderRepository.save(order.toOrder());

        List<ProductOrderDto> productOrderDtoList = order.getProductList();

        productOrderDtoList.stream().forEach(p -> {
            OrderQuantity orderQuantity = new OrderQuantity();
            orderQuantity.setOrderID(response.getId());
            orderQuantity.setProductCode(p.getCode());
            orderQuantity.setQuantity(p.getQuantity());
            orderQuantityRepository.save(orderQuantity);
        });

        return ResponseEntity.ok("OK");
    }

    @DeleteMapping(path = "/order/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        manufracturingOrderRepository.deleteById(id);
        return ResponseEntity.ok("OK");
    }
}
