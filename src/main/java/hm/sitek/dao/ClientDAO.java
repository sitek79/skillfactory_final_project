package hm.sitek.dao;

import hm.sitek.model.Client;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ClientDAO {
    private static final Map<Long, Client> cliMap = new HashMap<Long, Client>();

    static {
        initClients();
    }
    private static void initClients() {
        Client client1 = new Client(1,"Andrey", "Tikhonov", "opl-456-567", 0, "admin@kmail.ru", "+7 (8286) 322-23-22");
        Client client2 = new Client(2,"Sofya", "Tikhonova", "fgh-952-295", 0, "root@kmail.ru", "+7 (2226) 322-23-22");
        Client client3 = new Client(3,"Dana", "Smirnova", "iop-610-825", 0, "ghe@kmail.ru", "+7 (8152) 322-23-22");

        cliMap.put(client1.getId(), client1);
        cliMap.put(client2.getId(), client2);
        cliMap.put(client3.getId(), client3);
    }

    public Client getClient(long id) {
        return cliMap.get(id);
    }

    public Client addClient(Client client) {
        cliMap.put(client.getId(), client);
        return client;
    }

    public Client updateClient(Client client) {
        cliMap.put(client.getId(), client);
        return client;
    }

    public void deleteEmployee(String empNo) {
        cliMap.remove(empNo);
    }

    public List<Client> getAllEmployees() {
        Collection<Client> c = cliMap.values();
        List<Client> list = new ArrayList<Client>();
        list.addAll(c);
        return list;
    }
}
