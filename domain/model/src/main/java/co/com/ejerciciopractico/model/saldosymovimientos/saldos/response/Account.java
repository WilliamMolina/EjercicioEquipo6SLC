
package co.com.ejerciciopractico.model.saldosymovimientos.saldos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private Balances balances;

}
