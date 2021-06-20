package by.shipul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    RouteLocator gateway(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("random_animal",
                        route->route.path("/random-animal/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(gatewayFilterSpec ->
                                        gatewayFilterSpec.stripPrefix(1))
                        .uri("lb://random-animal"))
                .route("zoo_route",
                        route->route.path("/zoo/**")
                                .filters(gatewayFilterSpec ->
                                        gatewayFilterSpec.stripPrefix(1))
                        .uri("lb://zoo"))
                .build();
    }
}

