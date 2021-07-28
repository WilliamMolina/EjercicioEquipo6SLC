package co.com.ejerciciopractico.redis;

import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosResponse;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.CacheGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class ReactiveRedis implements CacheGateway {
    private final ReactiveRedisTemplate<String, String> template;
    private final ReactiveRedisTemplate<String, SaldosYMovimientosResponse> objectTemplate;

    @Override
    public Mono<String> findById(String key) {
        return template.opsForValue().get(key);
    }

    @Override
    public Mono<String> set(String key, String value) {
        Mono<Boolean> result = template.opsForValue().set(key, value);
        result.subscribe();
        return Mono.just(value);
    }

    @Override
    public Mono<SaldosYMovimientosResponse> setObject(String key, SaldosYMovimientosResponse saldosYMovimientosResponse, Duration duration){
        Mono<Boolean> result = objectTemplate.opsForValue().set( key, saldosYMovimientosResponse, duration);
        result.subscribe();
        return Mono.just(saldosYMovimientosResponse);
    }

    @Override
    public Mono<SaldosYMovimientosResponse> getObject(String key) {
        return objectTemplate.opsForValue().get(key);
    }
}
