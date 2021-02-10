package co.com.ejerciciopractico.consumer;

import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.SaldosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements SaldosGateway// implements Gateway from domain
{

    private final WebClient client;


    // these methods are an example that illustrates the implementation of WebClient.
    // You should use the methods that you implement from the Gateway from the domain.

    public Mono<ObjectResponse> testGet() {

        return client
            .get()
            .retrieve()
            .bodyToMono(ObjectResponse.class);

    }

    public Mono<ObjectResponse> testPost() {

        ObjectRequest request = ObjectRequest.builder()
            .val1("exampleval1")
            .val2("exampleval2")
            .build();

        return client
            .post()
            .body(Mono.just(request), ObjectRequest.class)
            .retrieve()
            .bodyToMono(ObjectResponse.class);
    }

    @Override
    public Mono<SaldosResponse> getSaldos() {

        return client.post().retrieve().bodyToMono(SaldosResponse.class);

    }
}