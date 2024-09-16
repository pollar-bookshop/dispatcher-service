package com.polarbookshop.dispatcherservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.function.Function;

// 외부 메시징 시스템과의 통합을 테스트하려고 하기 때문에 이 테스트는 비활성화 돼야함
//@FunctionalSpringBootTest
//public class DispatchingFunctionsIntegrationTests {
//
//    @Autowired
//    private FunctionCatalog catalog;
//
//    @Test
//    void packAndLabelOrder() {
//        Function<OrderAcceptedMessage, Flux<OrderDispatchedMessage>> packAndLabel =
//                catalog.lookup(Function.class, "pack|label");
//        long orderId = 121;
//
//        StepVerifier.create(packAndLabel.apply(new OrderAcceptedMessage(orderId)))
//                .expectNextMatches(dispatchedOrder ->
//                        dispatchedOrder.equals(new OrderDispatchedMessage(orderId)))
//                .verifyComplete();
//    }
//}
