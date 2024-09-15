package com.polarbookshop.dispatcherservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Configuration
public class DispatchingFunctions {
    private static final Logger log = LoggerFactory.getLogger(DispatchingFunctions.class);

    // 주문을 포장하는 비즈니스 로직을 구현하는 함수
    @Bean // 빈으로 정의된 함수는 스프링 클라우드 함수가 찾아서 관리할 수 있다. 빈으로 등록된 함수는 스프링 함수 프래임워크에 의해 추가 기능을 갖는다.
    public Function<OrderAcceptedMessage, Long> pack() {
        return orderAcceptedMessage -> {
            log.info("The order with id {} is packed.",
                    orderAcceptedMessage.orderId());
            return orderAcceptedMessage.orderId();
        };
    }

    // 주문의 아이디(Long 타입)을 입력 받고 OrderDispatchedMessage를 반환한다.
    @Bean
    public Function<Flux<Long>, Flux<OrderDispatchedMessage>> label() {
        return orderFlux -> orderFlux.map(orderId -> {
            log.info("The order with id {} is labeled.", orderId);
            return new OrderDispatchedMessage(orderId);
        });
    }
}
