package co.com.ejerciciopractico.api;

import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosRequest;
import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosResponse;
import co.com.ejerciciopractico.usecase.saldosymovimientos.SaldosYMovimientosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private  final SaldosYMovimientosUseCase useCase;
//private  final UseCase2 useCase2;
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        Mono<SaldosYMovimientosRequest> request = serverRequest.bodyToMono(SaldosYMovimientosRequest.class);
        Mono<SaldosYMovimientosResponse> response = request.flatMap(r -> useCase.getSaldosYMovimientos(r));



        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, SaldosYMovimientosResponse.class);
    }

}
