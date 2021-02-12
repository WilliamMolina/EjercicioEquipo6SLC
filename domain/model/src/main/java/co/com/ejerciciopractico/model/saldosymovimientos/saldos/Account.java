
package co.com.ejerciciopractico.model.saldosymovimientos.saldos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String number;
    private String type;



}
