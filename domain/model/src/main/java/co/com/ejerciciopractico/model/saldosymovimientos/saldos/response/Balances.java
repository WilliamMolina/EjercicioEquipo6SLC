
package co.com.ejerciciopractico.model.saldosymovimientos.saldos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Balances {

    private Long agreedRemittanceQuota;
    private String available;
    private Long availableOverdraftBalance;
    private Object availableOverdraftQuota;
    private Long blocked;
    private String cash;
    private String cashStartDay;
    private Object normalInterest;
    private Object overdraftValue;
    private String pockets;
    private String receivable;
    private Long remittanceQuota;
    private Long remittanceQuotaUsage;
    private Object suspensionInterest;
    private Long unavailableClearing;
    private Long unavailableStartDayClearingStartDay;


}
