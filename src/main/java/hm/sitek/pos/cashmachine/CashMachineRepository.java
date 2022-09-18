package hm.sitek.pos.cashmachine;

import hm.sitek.pos.cashmachine.CashMachine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CashMachineRepository extends CrudRepository<CashMachine, Long> {
    //List<CashMachine> findByName(String currency, String client_id, String balance, String card, String account_number);
    List<CashMachine> findByCard(String card);
}
