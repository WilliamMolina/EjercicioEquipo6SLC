package co.com.ejerciciopractico.consumer;

import co.com.ejerciciopractico.model.saldosymovimientos.gateways.MovimientosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response.MovimientosResponse;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.SaldosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovimientosRestConsumer implements MovimientosGateway// implements Gateway from domain
{

    private final WebClient client;


    // these methods are an example that illustrates the implementation of WebClient.
    // You should use the methods that you implement from the Gateway from the domain.

    @Override
    public Mono<MovimientosResponse> getMovimientos() {

        return client.post().retrieve().bodyToMono(MovimientosResponse.class);
    }
}