
package co.com.ejerciciopractico.model.saldosymovimientos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Office {

    private String code;
    private String name;

}
