package hm.sitek.controller;

import hm.sitek.form.ClientForm;
import hm.sitek.model.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CashMachineController {
    private static List<Client> persons = new ArrayList<Client>();

    static {
        persons.add(new Client(1,"Andrey", "Tikhonov", "xyz-234-567", 0, "admin@kmail.ru", "+7 (232) 322-23-22"));
        persons.add(new Client(2, "Aleksey", "Tikhonov", "xyz-234-568", 0, "admin@hmail.ru", "+7 (111) 555-88-99"));
    }

    // Вводится (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }

    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        ClientForm personForm = new ClientForm();
        model.addAttribute("personForm", personForm);

        return "addPerson";
    }

    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("personForm") ClientForm personForm) {

        long id = personForm.getId();
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
        String accountNumber = personForm.getAccountNumber();
        double balance = personForm.getBalance();
        String email = personForm.getEmail();
        String phone = personForm.getPhone();

        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Client newClient = new Client(id, firstName, lastName, accountNumber, balance, email, phone);
            persons.add(newClient);
            //System.out.println(persons.toString());

            return "redirect:/personList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }
}
