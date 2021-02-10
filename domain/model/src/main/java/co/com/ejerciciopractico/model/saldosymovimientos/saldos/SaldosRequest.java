
package co.com.ejerciciopractico.model.saldosymovimientos.saldos;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SaldosRequest {

    private List<SaldosRequestData> data;


}
