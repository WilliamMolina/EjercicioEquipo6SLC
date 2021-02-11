
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

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
