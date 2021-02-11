
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatedTransferAccount {

    private String number;
    private String type;


}
