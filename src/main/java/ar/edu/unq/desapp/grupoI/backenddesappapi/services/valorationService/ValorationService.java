package ar.edu.unq.desapp.grupoi.backenddesappapi.services.valorationService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.NoSuchValoration;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.valoration.ValorationRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.reviewService.ReviewService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@NoArgsConstructor
public class ValorationService {

    @Autowired
    private ValorationRepository valorationRepository;

    @Autowired
    private ReviewService reviewService;

    public ValorationService(ValorationRepository valorationRepository) {
        this.valorationRepository = valorationRepository;
    }

    public List<Valoration> getValorations() {
        List<Valoration> result = valorationRepository.findAll();
        for (Valoration v : result) {
            v.setLike(v.getClike().equalsIgnoreCase("true"));
        }
        return result;
    }

    public Valoration getValorationById(Long id) {
        Optional<Valoration> valoration = valorationRepository.findById(id);
        valoration.orElseThrow(() -> new NoSuchValoration(HttpStatus.BAD_REQUEST));
        return valoration.get();
    }

    public List<Valoration> getValorationsOfReview(Long id) {
        return valorationRepository.findByReview_id(id);
    }

    public void addValoration(Valoration valoration) {
        reviewService.findById(valoration.getReview_id());
        this.valorationRepository.save(valoration);
    }
}
