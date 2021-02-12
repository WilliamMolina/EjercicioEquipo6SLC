package co.com.ejerciciopractico.consumer;

import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosRequest;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.Account;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.SaldosRequest;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.SaldosRequestData;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.SaldosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class RestConsumer implements SaldosGateway// implements Gateway from domain
{

    @Autowired
    @Qualifier("saldos")
    private WebClient client;
    // these methods are an example that illustrates the implementation of WebClient.
    // You should use the methods that you implement from the Gateway from the domain.


    @Override
    public Mono<SaldosResponse> getSaldos(SaldosYMovimientosRequest request) {

        SaldosRequest saldosRequest = SaldosRequest.builder()
                .data(Arrays.asList(SaldosRequestData
                        .builder()
                        .account(Account
                                .builder()
                                .number(request.getData().get(0).getAccount().getNumber())
                                .type(request.getData().get(0).getAccount().getType())
                                .build())
                        .build()))
                .build();

        return client.post().body(Mono.just(saldosRequest), SaldosRequest.class).retrieve().bodyToMono(SaldosResponse.class);

    }
}