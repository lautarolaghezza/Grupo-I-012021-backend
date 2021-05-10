package ar.edu.unq.desapp.grupoi.backenddesappapi.services.valorationService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.valoration.ValorationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValorationServiceImpl{

    @Autowired
    private ValorationRepository valorationRepository;

    public List<Valoration> getValorations() {
        List<Valoration> result = valorationRepository.findAll();
        for (Valoration v : result){
            v.setLike(v.getClike().equalsIgnoreCase("true"));
        }
        return result;
    }

    public Valoration getValorationById(Long id) {
        return valorationRepository.findById(id);
    }

    public List<Valoration> getValorationsOfReview(Long id) {
        return valorationRepository.findByReview_id(id);
    }

    public void addValoration(Valoration valoration) {
        this.valorationRepository.save(valoration);
    }
}
