
package co.com.ejerciciopractico.model.saldosymovimientos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Balance {

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
