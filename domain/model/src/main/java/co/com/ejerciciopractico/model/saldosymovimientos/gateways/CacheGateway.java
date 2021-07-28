package co.com.ejerciciopractico.model.saldosymovimientos.gateways;

import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

public interface CacheGateway {
    Mono<String> findById(String key);
    Mono<String> set(String key, String value);
    Mono<SaldosYMovimientosResponse> setObject(String key, SaldosYMovimientosResponse saldosYMovimientosResponse, Duration duration);
    Mono<SaldosYMovimientosResponse> getObject(String key);
}
