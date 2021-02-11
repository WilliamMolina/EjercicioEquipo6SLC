package co.com.ejerciciopractico.config;

import co.com.ejerciciopractico.model.saldosymovimientos.gateways.MovimientosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.usecase.saldosymovimientos.SaldosYMovimientosUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConsumerConfig {

    @Value("${adapter.restconsumer.url}")
    private String url;

    @Bean(name = "saldos")
    public WebClient getWebClient() {
        return WebClient.builder()
            .baseUrl(url)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .build();
    }

    @Bean(name = "movimientos")
    public WebClient getMovimientosWebClient() {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }

    @Bean
    public SaldosYMovimientosUseCase getUseCase(SaldosGateway saldos, MovimientosGateway movimientos)
    {
        return new SaldosYMovimientosUseCase(saldos, movimientos);

    }

}
