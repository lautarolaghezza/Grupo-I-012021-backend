package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.valorationService.ValorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ValorationController {
    @Autowired
    private ValorationService valorationService;

    @GetMapping(value = "valorations")
    public List<Valoration> getValorarions(){return valorationService.getValorations();}

    @GetMapping(value = "valorations/{id}")
    public Valoration getValorarionById(@PathVariable Long id){return valorationService.getValorationById(id);}

    @GetMapping(value = "valorations/review/{id}")
    public List<Valoration> getValorarionByReview(@PathVariable Long id){return valorationService.getValorationsOfReview(id);}

    @PostMapping(value = "valoration")
    public void newPremiumReview(@RequestBody Valoration valoration) {
        valorationService.addValoration(valoration);
    }
}
