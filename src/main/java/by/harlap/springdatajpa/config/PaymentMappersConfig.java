package by.harlap.springdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import by.harlap.springdatajpa.utils.PaymentMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class PaymentMappersConfig {

    @Bean
    public Map<Class, PaymentMapper> paymentMappers(List<PaymentMapper<?>> handleDtos) {
        final Map<Class, PaymentMapper> correspondHandlersDto = new HashMap<>();

        handleDtos.forEach(it -> correspondHandlersDto.put(it.getHandledClass(), it));

        return correspondHandlersDto;
    }
}
