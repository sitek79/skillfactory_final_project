package hm.sitek.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    private long id;
    private long balance;

    public Client() {}

    public Client(long id, long balance) {
        //this.id = id;
        this.balance = balance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "balance", nullable = false)
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", balance=" + balance + "]";
    }
}
