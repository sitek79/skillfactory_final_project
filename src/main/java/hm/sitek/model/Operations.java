package hm.sitek.model;

import javax.persistence.*;

@Entity
@Table(name = "OPERATIONS")
public class Operations {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "CLIENT_ID")
    private long id;
    @Column(name = "ID_OPERATIONS")
    private long id_operations;
    @Column(name = "TYPE")
    private int type;
    @Column(name = "AMOUNT")
    private long amount;

    public Operations() {}

    public Operations(long id, long id_operation, int type, long amount) {
        this.id = id;
        this.id_operations = id_operation;
        this.type = type;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_operations() {
        return id_operations;
    }

    public void setId_operations(long id_operation) {
        this.id_operations = id_operation;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "id=" + id +
                ", id_operations=" + id_operations +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
