package co.com.ejerciciopractico.consumer;

import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosRequest;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.MovimientosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.*;
import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response.MovimientosResponse;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.SaldosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MovimientosRestConsumer implements MovimientosGateway// implements Gateway from domain
{

    @Autowired
    @Qualifier("movimientos")
    private  WebClient client;


    // these methods are an example that illustrates the implementation of WebClient.
    // You should use the methods that you implement from the Gateway from the domain.

    @Override
    public Mono<MovimientosResponse> getMovimientos(SaldosYMovimientosRequest request) {

        MovimientosRequest movimientosRequest = MovimientosRequest
                .builder()
                .data(Arrays.asList(MovimientosDataRequest
                        .builder()
                        .account(Account
                                .builder()
                                .number(request.getData().get(0).getAccount().getNumber())
                                .type(request.getData().get(0).getAccount().getType())
                                .build())
                        .office(Office
                                .builder()
                                .code(request.getData().get(0).getOffice().getCode())
                                .name(request.getData().get(0).getOffice().getName())
                                .build())
                        .pagination(Pagination
                                .builder()
                                .key(request.getData().get(0).getPagination().getKey())
                                .size(request.getData().get(0).getPagination().getSize())
                                .build())
                        .transaction(Transaction
                                .builder()
                                .checkNumber(request.getData().get(0).getTransaction().getCheckNumber())
                                .description(request.getData().get(0).getTransaction().getDescription())
                                .endDate(request.getData().get(0).getTransaction().getEndDate())
                                .group(request.getData().get(0).getTransaction().getGroup())
                                .maxAmount(request.getData().get(0).getTransaction().getMaxAmount())
                                .minAmount(request.getData().get(0).getTransaction().getMinAmount())
                                .startDate(request.getData().get(0).getTransaction().getStartDate())
                                .type(request.getData().get(0).getTransaction().getType())
                                .build())
                        .build()))
                .build();
        return client.post().body(Mono.just(movimientosRequest), MovimientosRequest.class).retrieve().bodyToMono(MovimientosResponse.class);
    }
}