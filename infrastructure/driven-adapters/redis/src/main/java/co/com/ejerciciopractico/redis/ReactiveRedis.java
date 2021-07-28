package co.com.ejerciciopractico.redis;

import co.com.ejerciciopractico.model.saldosymovimientos.gateways.CacheGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReactiveRedis implements CacheGateway {
    private final ReactiveRedisTemplate<String, String> template;

    @Override
    public Mono<String> findById(String key) {
        return template.opsForValue().get(key);
    }

}
