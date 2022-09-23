package hm.sitek.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "balance")
    private long balance;

    public Client() {}

    public Client(long id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public Client(long balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", balance=" + balance + "]";
    }
}