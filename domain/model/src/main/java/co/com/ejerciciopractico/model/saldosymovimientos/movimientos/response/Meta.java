
package co.com.ejerciciopractico.model.saldosymovimientos.movimientos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

    private String _applicationId;
    private Boolean _flagMoreRecords;
    private String _messageId;
    private String _requestTimeStamp;
    private Long _responseSize;
    private String _version;


}
