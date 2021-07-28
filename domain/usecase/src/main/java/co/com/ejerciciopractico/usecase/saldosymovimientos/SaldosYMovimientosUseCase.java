package co.com.ejerciciopractico.usecase.saldosymovimientos;

import co.com.ejerciciopractico.model.saldosymovimientos.*;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.CacheGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.MovimientosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.gateways.SaldosGateway;
import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response.Meta;
import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response.MovimientosDataResponse;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.response.Balances;
import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response.Transaction;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import sun.security.util.Cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class SaldosYMovimientosUseCase {
    /* Lógica */
    private final SaldosGateway saldos;
    private  final MovimientosGateway movimientos;
    private final CacheGateway cacheGateway;

    public Mono<SaldosYMovimientosResponse> getSaldosYMovimientos(SaldosYMovimientosRequest request){

        return Mono.zip(saldos.getSaldos(request), movimientos.getMovimientos(request), cacheGateway.findById("cost"))
                .flatMap(saldosYMovimientosResponse -> {

            Balances dataBalances = saldosYMovimientosResponse.getT1().getData().get(0).getAccount().getBalances();
            MovimientosDataResponse dataMovimientos = saldosYMovimientosResponse.getT2().getData().get(0);
            Meta meta = saldosYMovimientosResponse.getT2().getMeta();
            List<Transaction> transaction = dataMovimientos.getTransaction();
            Links links = saldosYMovimientosResponse.getT2().getLinks();

            return Mono.just(
                    SaldosYMovimientosResponse.builder()
                            .cost(saldosYMovimientosResponse.getT3())
                            .meta(Meta.builder()
                                    ._responseSize(meta.get_responseSize())
                                    ._flagMoreRecords(meta.get_flagMoreRecords())
                                    .build())

                            .data(Arrays.asList(
                                    SaldosYMovimientosData.builder()
                                            .account(Account.builder()
                                                    .balance(Balance.builder()
                                                            .agreedRemittanceQuota(dataBalances.getAgreedRemittanceQuota())
                                                            .cash(dataBalances.getCash())
                                                            .available(dataBalances.getAvailable())
                                                            .availableOverdraftBalance(dataBalances.getAvailableOverdraftBalance())
                                                            .availableOverdraftQuota(dataBalances.getAvailableOverdraftQuota())
                                                            .blocked(dataBalances.getBlocked())
                                                            .cashStartDay(dataBalances.getCashStartDay())
                                                            .normalInterest(dataBalances.getNormalInterest())
                                                            .overdraftValue(dataBalances.getOverdraftValue())
                                                            .pockets(dataBalances.getPockets())
                                                            .receivable(dataBalances.getReceivable())
                                                            .remittanceQuota(dataBalances.getRemittanceQuota())
                                                            .remittanceQuotaUsage(dataBalances.getRemittanceQuotaUsage())
                                                            .suspensionInterest(dataBalances.getSuspensionInterest())
                                                            .unavailableClearing(dataBalances.getUnavailableClearing())
                                                            .unavailableStartDayClearingStartDay(dataBalances.getUnavailableStartDayClearingStartDay())
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .customer(Customer.builder()
                                                    .name(dataMovimientos.getCustomer().getName())
                                                    .build())
                                            .office(Office.builder()
                                                    .code(dataMovimientos.getOffice().getCode())
                                                    .name(dataMovimientos.getOffice().getName())
                                                    .build())
                                            .relatedTransferAccount(RelatedTransferAccount.builder()
                                                    .number(dataMovimientos.getRelatedTransferAccount().getNumber())
                                                    .type(dataMovimientos.getRelatedTransferAccount().getType())
                                                    .build())
                                            .transaction(construirTransactionList(transaction))
                                            .build()
                            ))
                            .links(links)
                            .build()
            );
        });

    }

    private List<TransactionSaldosYMovimientos> construirTransactionList( List<Transaction> transacciones) {

        List<TransactionSaldosYMovimientos> listaTransacciones =  new ArrayList<>();

        transacciones.forEach(transacion->
                listaTransacciones.add(TransactionSaldosYMovimientos.builder()
                        .amount(transacion.getAmount())
                        .checkNumber(transacion.getCheckNumber())
                        .description(transacion.getDescription())
                        .id(transacion.getId())
                        .postedDate(transacion.getPostedDate())
                        .reference1(transacion.getReference1())
                        .reference2(transacion.getReference2())
                        .reference3(transacion.getReference3())
                        .type(transacion.getType())
                        .build()
                )

        );

        return listaTransacciones;
    }
}
