
package co.com.ejerciciopractico.model.saldosymovimientos;

import java.util.List;

import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response.Meta;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class SaldosYMovimientosResponse {

    private Meta meta;
    private List<SaldosYMovimientosData> data;
    private Links links;

}
