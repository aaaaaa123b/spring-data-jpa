package by.harlap.springdatajpa.controller;

import by.harlap.springdatajpa.dto.PaymentResponse;
import by.harlap.springdatajpa.entity.Payment;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import by.harlap.springdatajpa.service.PaymentService;
import by.harlap.springdatajpa.utils.PaymentMapper;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Resource
    private Map<Class, PaymentMapper> correspondHandlersDto;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long id) {
        Payment res = paymentService.findById(id);
        PaymentMapper handler = correspondHandlersDto.get(res.getClass());
        PaymentResponse dto = handler.toResponseDto(res);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> create(@RequestBody PaymentResponse dto) {
        Class clazz = dto.paymentType().getEntityClass();
        PaymentMapper handler = correspondHandlersDto.get(clazz);
        Payment payment = (Payment) handler.toEntity(dto);
        payment = paymentService.create(payment);
        dto = handler.toResponseDto(payment);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
