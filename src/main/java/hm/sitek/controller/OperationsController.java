package hm.sitek.controller;

import hm.sitek.model.Operations;
import hm.sitek.repository.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/terminal/v1")
public class OperationsController {

    @Autowired
    OperationsRepository operationsRepository;

    @GetMapping("/operations")
    public List<Operations> getOperationList() {
        return operationsRepository.findAll();
    }
}
