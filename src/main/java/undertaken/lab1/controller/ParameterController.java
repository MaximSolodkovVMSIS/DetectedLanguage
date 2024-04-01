package undertaken.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import undertaken.lab1.dto.ParameterList;
import undertaken.lab1.service.ParameterService;

@RestController
public class ParameterController {

    private final ParameterService parameterService;

    @Autowired
    public ParameterController(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    @PostMapping("/bulk")
    public void processBulkParameters(@RequestBody ParameterList parameterList) {
        parameterService.processParameters(parameterList);
    }
}