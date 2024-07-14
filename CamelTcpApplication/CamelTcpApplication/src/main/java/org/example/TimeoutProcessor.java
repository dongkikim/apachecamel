package org.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TimeoutProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        // 타임아웃 예외 처리 로직을 여기에 추가합니다.
        exchange.getIn().setBody("Timeout occurred while processing the message.");
    }
}
