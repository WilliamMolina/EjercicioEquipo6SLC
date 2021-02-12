
package co.com.ejerciciopractico.model.saldosymovimientos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class TransactionSaldosYMovimientos {

    private Long amount;
    private String checkNumber;
    private String description;
    private String id;
    private String postedDate;
    private String reference1;
    private String reference2;
    private String reference3;
    private String type;

}
