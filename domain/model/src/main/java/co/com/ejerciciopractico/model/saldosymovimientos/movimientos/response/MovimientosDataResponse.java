
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientosDataResponse {

    private Customer customer;
    private Office office;
    private RelatedTransferAccount relatedTransferAccount;
    private List<Transaction> transaction;


}
