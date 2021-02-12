package co.com.ejerciciopractico.config;

import co.com.ejerciciopractico.model.saldosymovimientos.gateways.MovimientosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.usecase.saldosymovimientos.SaldosYMovimientosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConsumerConfig {

    @Value("${adapter.saldos.url}")
    private String urlSaldos;
    @Value("${adapter.movimientos.url}")
    private String urlMovimientos;


    @Bean(name = "saldos")
    public WebClient getWebClient() {
        return WebClient.builder()
            .baseUrl(urlSaldos)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .build();
    }

    @Bean(name = "movimientos")
    public WebClient getMovimientosWebClient() {
        return WebClient.builder()
                .baseUrl(urlMovimientos)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }

    @Bean
    public SaldosYMovimientosUseCase getUseCase(SaldosGateway saldos, MovimientosGateway movimientos)
    {
        return new SaldosYMovimientosUseCase(saldos, movimientos);

    }

}
