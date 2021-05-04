package service.valorationService;

import model.user.User;
import model.valoration.Valoration;
import repository.valoration.ValorationRepository;
import repository.valoration.ValorationRepositoryImpl;

import java.util.List;

public class ValorationServiceImpl implements ValorationService{

    private ValorationRepository valorationRepository;

    public ValorationServiceImpl() {
        this.valorationRepository = new ValorationRepositoryImpl();
    }

    @Override
    public List<Valoration> getValorations() {
        return valorationRepository.getValorations();
    }

    @Override
    public List<Valoration> getValorationsOf(String tconst) {
        return valorationRepository.getValorationsOf(tconst);
    }

    @Override
    public void addValoration(Valoration valoration, User user) {
        this.valorationRepository.generateValoratio(valoration, user);
    }
}
