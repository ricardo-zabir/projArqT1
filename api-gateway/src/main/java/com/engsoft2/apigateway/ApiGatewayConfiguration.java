package com.engsoft2.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/cidadesatendidas/**")
						.uri("lb://monolito"))
				.route(p -> p.path("/retornaPromoVigente/**")
						.uri("lb://monolito"))
				.route(p -> p.path("/validacep/**")
						.uri("lb://monolito"))
				.route(p -> p.path("/calculafrete/**")
						.uri("lb://monolito"))
				.route(p -> p.path("/listaorcamentospordata/**")
						.uri("lb://micro-orcamento"))
				.build();
	}    
}
