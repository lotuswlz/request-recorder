package tech.cathywu.requestmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.cathywu.requestmonitor.model.RequestDto;
import tech.cathywu.requestmonitor.service.RequestService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/records")
    public List<RequestDto> loadByMethod(@RequestParam(value = "method", required = false) String method) {
        if (method == null || method.isBlank()) {
            return requestService.getAllRecords();
        }
        return requestService.getRecordsByMethod(method);
    }

}
