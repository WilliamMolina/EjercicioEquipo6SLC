package co.com.ejerciciopractico.model.saldosymovimientos.gateways;

import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosRequest;
import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response.MovimientosResponse;
import reactor.core.publisher.Mono;

public interface MovimientosGateway {

    Mono<MovimientosResponse> getMovimientos(SaldosYMovimientosRequest request);
}
