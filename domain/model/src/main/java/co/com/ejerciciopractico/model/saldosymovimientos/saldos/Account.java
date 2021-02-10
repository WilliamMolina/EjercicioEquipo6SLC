
package co.com.ejerciciopractico.model.saldosymovimientos.saldos;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Account {

    private String number;
    private String type;



}
