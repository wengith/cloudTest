package ins.platform.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wen
 * @date: 2019/1/14 11:47
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class GatewayApplication {

	/*@Bean
	public RouteLocator myRouteLocator(RouteLocatorBuilder builder){

		return builder.routes()
				.route(r -> r.path("/baidu").
						uri("http://baidu.com:80/")
				)
				.route("websocket_route", r -> r.path("/apitopic1/**")
						.uri("ws://127.0.0.1:6605"))
				.route(r -> r.path("/userapi3/**")
						.filters(f -> f.addResponseHeader("X-AnotherHeader", "testapi3"))

						.uri("lb://user-service/")
				)
				.build();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


}
