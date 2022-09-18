package hm.sitek.pos.controller;

import hm.sitek.pos.test.domain.Message;
import hm.sitek.pos.test.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CashMachineController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/settings")
    String hello() {
        //return "Страница настроек банкомата.";
        return "/settings";
    }

    @GetMapping
    public String user(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "/user";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "/user";
    }
}
