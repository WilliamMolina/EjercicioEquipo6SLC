
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response;

import co.com.ejerciciopractico.model.saldosymovimientos.Links;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientosResponse {

    private List<MovimientosDataResponse> data;
    private Links links;
    private Meta meta;


}
