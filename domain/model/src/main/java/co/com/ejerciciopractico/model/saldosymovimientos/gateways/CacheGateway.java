package co.com.ejerciciopractico.model.saldosymovimientos.gateways;

import reactor.core.publisher.Mono;

public interface CacheGateway {
    Mono<String> findById(String key);
}
