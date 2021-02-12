
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    private Long key;
    private Long size;


}
