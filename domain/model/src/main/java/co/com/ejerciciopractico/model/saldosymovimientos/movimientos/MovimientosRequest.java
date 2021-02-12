
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovimientosRequest {

    private List<MovimientosDataRequest> data;

}
