
package co.com.ejerciciopractico.model.saldosymovimientos.saldos.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SaldosResponse {


    private List<SaldosResponseData> data;



}
