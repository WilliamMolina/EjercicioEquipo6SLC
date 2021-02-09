package co.com.ejerciciopractico.usecase.saldosymovimientos;

import co.com.ejerciciopractico.model.saldosymovimientos.*;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@RequiredArgsConstructor
public class SaldosYMovimientosUseCase {
    /* Lógica */
    public Mono<SaldosYMovimientosResponse> getSaldosYMovimientos(){
        return Mono.just(
                SaldosYMovimientosResponse.builder()
                .data(Arrays.asList(
                        SaldosYMovimientosData.builder()
                        .account(Account.builder()
                            .balance(Balance.builder()
                                    .cash("Prueba balance")
                                    .build()
                            )
                            .build()
                        )
                        .customer(Customer.builder().build())
                        .office(Office.builder().build())
                        .relatedTransferAccount(RelatedTransferAccount.builder().build())
                        .transaction(Arrays.asList(Transaction.builder().build()))
                        .build()
                ))
                        .links(Links.builder()
                        .self("Prueba").build())
                .build()
        );
    }
}
