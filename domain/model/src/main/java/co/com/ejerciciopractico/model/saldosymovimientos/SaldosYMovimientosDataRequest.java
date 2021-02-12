package co.com.ejerciciopractico.model.saldosymovimientos;

import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.Pagination;
import co.com.ejerciciopractico.model.saldosymovimientos.movimientos.Transaction;
import co.com.ejerciciopractico.model.saldosymovimientos.saldos.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaldosYMovimientosDataRequest {

    private Pagination pagination;
    private Account account;
    private Transaction transaction;
    private Office office;
}
