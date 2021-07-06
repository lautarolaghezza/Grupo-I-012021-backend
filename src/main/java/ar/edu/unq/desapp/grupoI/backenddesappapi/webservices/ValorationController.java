package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.LogExecutionTime;
import ar.edu.unq.desapp.grupoi.backenddesappapi.Utils.BaseController;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.valorationService.ValorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ValorationController extends BaseController {
    @Autowired
    private ValorationService valorationService;

    @LogExecutionTime
    @GetMapping(value = "valorations")
    public List<Valoration> getValorarions(@RequestHeader("api-key") String apiKey){
        validateApiKey(apiKey);
        return valorationService.getValorations();}

    @LogExecutionTime
    @GetMapping(value = "valorations/{id}")
    public Valoration getValorarionById(@RequestHeader("api-key") String apiKey, @PathVariable Long id){
        validateApiKey(apiKey);
        return valorationService.getValorationById(id);}

    @LogExecutionTime
    @GetMapping(value = "valorations/review/{id}")
    public List<Valoration> getValorarionByReview(@RequestHeader("api-key") String apiKey, @PathVariable Long id){
        validateApiKey(apiKey);
        return valorationService.getValorationsOfReview(id);}

    @LogExecutionTime
    @PostMapping(value = "valoration")
    public void newPremiumReview(@RequestHeader("api-key") String apiKey, @RequestBody Valoration valoration) {
        validateApiKey(apiKey);
        valorationService.addValoration(valoration);
    }
}
