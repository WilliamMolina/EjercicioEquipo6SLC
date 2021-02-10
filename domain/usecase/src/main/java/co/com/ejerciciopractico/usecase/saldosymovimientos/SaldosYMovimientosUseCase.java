package co.com.ejerciciopractico.usecase.saldosymovimientos;

import co.com.ejerciciopractico.model.saldosymovimientos.*;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.Balances;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.SaldosResponse;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.SaldosResponseData;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@RequiredArgsConstructor
public class SaldosYMovimientosUseCase {
    /* Lógica */
    private final SaldosGateway saldos;

    public Mono<SaldosYMovimientosResponse> getSaldosYMovimientos(){

        return saldos.getSaldos().flatMap(saldosResponse -> {
            Balances data = saldosResponse.getData().get(0).getAccount().getBalances();
            return Mono.just(
                    SaldosYMovimientosResponse.builder()
                            .data(Arrays.asList(
                                    SaldosYMovimientosData.builder()
                                            .account(Account.builder()
                                                    .balance(Balance.builder()
                                                            .agreedRemittanceQuota(data.getAgreedRemittanceQuota())
                                                            .cash(data.getCash())
                                                            .available(data.getAvailable())
                                                            .availableOverdraftBalance(data.getAvailableOverdraftBalance())
                                                            .availableOverdraftQuota(data.getAvailableOverdraftQuota())
                                                            .blocked(data.getBlocked())
                                                            .cashStartDay(data.getCashStartDay())
                                                            .normalInterest(data.getNormalInterest())
                                                            .overdraftValue(data.getOverdraftValue())
                                                            .pockets(data.getPockets())
                                                            .receivable(data.getReceivable())
                                                            .remittanceQuota(data.getRemittanceQuota())
                                                            .remittanceQuotaUsage(data.getRemittanceQuotaUsage())
                                                            .suspensionInterest(data.getSuspensionInterest())
                                                            .unavailableClearing(data.getUnavailableClearing())
                                                            .unavailableStartDayClearingStartDay(data.getUnavailableStartDayClearingStartDay())
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
        });

    }
}
