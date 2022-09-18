package hm.sitek.pos.cashmachine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CashMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String currency;
    private String client_id;
    private String balance;
    private String card;
    private String account_number;

    //private UUID uid;

    public CashMachine() {}

    /*public CashMachine(String currency) {
        this.currency = currency;
    }*/

    public CashMachine(String currency, String client_id, String balance, String card, String account_number) {
        this.currency = currency;
        this.client_id = client_id;
        this.balance = balance;
        this.card = card;
        this.account_number = account_number;
    }

    //getters, setters, toString...
}
