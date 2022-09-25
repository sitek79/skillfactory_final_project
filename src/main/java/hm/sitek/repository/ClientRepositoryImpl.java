package hm.sitek.repository;

import hm.sitek.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class ClientRepositoryImpl implements ClientRepositoryCustom {

    @Autowired
            @Lazy
    ClientRepository clientRepository;

    public void getBalance() {
        System.out.println("<-- Balance -->");
    }

    public void putMoney(){
        System.out.println("<-- Put Money -->");
    }
    public void takeMoney() {
        System.out.println("<-- Take Money -->");
    }
}
