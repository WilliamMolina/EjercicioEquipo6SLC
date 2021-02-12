package co.com.ejerciciopractico.model.saldosymovimientos.gateways;

import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosRequest;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.SaldosResponse;
import reactor.core.publisher.Mono;

public interface SaldosGateway {

    Mono<SaldosResponse> getSaldos(SaldosYMovimientosRequest request);
}
