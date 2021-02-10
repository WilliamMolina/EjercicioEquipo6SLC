
package co.com.ejerciciopractico.model.saldosymovimientos.saldos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaldosRequestData {

    private Account account;

}
