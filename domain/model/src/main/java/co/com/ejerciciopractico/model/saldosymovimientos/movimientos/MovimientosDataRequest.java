
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovimientosDataRequest {

    private Account account;
    private Office office;
    private Pagination pagination;
    private Transaction transaction;


}
