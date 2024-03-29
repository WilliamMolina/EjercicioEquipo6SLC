package co.com.ejerciciopractico.config;

import co.com.ejerciciopractico.model.saldosymovimientos.SaldosYMovimientosResponse;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.CacheGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.MovimientosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.usecase.saldosymovimientos.SaldosYMovimientosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConsumerConfig {

    @Value("${adapter.saldos.url}")
    private String urlSaldos;
    @Value("${adapter.movimientos.url}")
    private String urlMovimientos;


    @Bean(name = "saldos")
    public WebClient getWebClient() {
        return WebClient.builder()
            .baseUrl(urlSaldos)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .build();
    }

    @Bean(name = "movimientos")
    public WebClient getMovimientosWebClient() {
        return WebClient.builder()
                .baseUrl(urlMovimientos)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }

    @Bean
    public SaldosYMovimientosUseCase getUseCase(SaldosGateway saldos, MovimientosGateway movimientos, CacheGateway cacheGateway)
    {
        return new SaldosYMovimientosUseCase(saldos, movimientos, cacheGateway);
    }

    @Bean
    public ReactiveRedisTemplate<String, SaldosYMovimientosResponse> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<SaldosYMovimientosResponse> serializer = new Jackson2JsonRedisSerializer<>(SaldosYMovimientosResponse.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, SaldosYMovimientosResponse> builder = RedisSerializationContext
                .newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, SaldosYMovimientosResponse> context = builder.value(serializer).build();
        return new ReactiveRedisTemplate<>(factory, context);
    }

}
