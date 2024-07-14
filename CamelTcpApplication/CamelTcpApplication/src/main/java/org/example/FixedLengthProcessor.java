package org.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FixedLengthProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        // 메시지 처리 로직을 여기에 추가합니다.
        exchange.getIn().setBody(body.trim());
    }
}
