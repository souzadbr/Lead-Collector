package br.com.zup.LeadCollector.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/leads")
@RestControllerAdvice
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PutMapping
    public Lead cadastrarLead (@RequestBody @Valid Lead lead){
        return leadService.salvarLead(lead);
    }
}
