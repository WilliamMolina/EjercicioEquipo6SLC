
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {

    private Object checkNumber;
    private Object description;
    private String endDate;
    private Object group;
    private Object maxAmount;
    private Object minAmount;
    private String startDate;
    private String type;


}
