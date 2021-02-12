package co.com.ejerciciopractico.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class Router {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(POST("/api/saldosymovimientos").and(contentType(APPLICATION_JSON)).and(accept(APPLICATION_JSON)), handler::listenGETUseCase);

    }
}
