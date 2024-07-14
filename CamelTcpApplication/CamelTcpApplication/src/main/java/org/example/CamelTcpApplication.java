package org.example;

import org.apache.camel.CamelContext;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CamelTcpApplication {

    /*

    private void addRouteDefinitions(CamelContext camelContext, List<RouteDefinition> routeDefinitions) {
        try {
            camelContext.addRoutes(routeDefinitions);
        } catch (Exception e) {
            throw new RuntimeCamelException(e);
        }
    }
    */

    public static void main(String[] args) throws Exception {
        // Spring Application Context를 로드합니다.
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");

        // SpringCamelContext를 생성합니다.
        CamelContext camelContext = SpringCamelContext.springCamelContext(applicationContext, false);

        // Camel Context를 시작합니다.
        camelContext.start();

        // 애플리케이션을 종료하지 않고 대기합니다.
        Thread.sleep(Long.MAX_VALUE);

        // Camel Context를 종료합니다.
        camelContext.stop();
        applicationContext.close();
    }
}
