
package co.com.ejerciciopractico.model.saldosymovimientos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class SaldosYMovimientosResponse {

    private List<SaldosYMovimientosData> data;
    private Links links;

}
