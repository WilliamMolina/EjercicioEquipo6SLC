
package co.com.ejerciciopractico.model.saldosymovimientos.saldos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaldosResponse {


    private List<SaldosResponseData> data;



}
