
package co.com.ejerciciopractico.model.saldosymovimientos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedTransferAccount {

    private String number;
    private String type;

}
