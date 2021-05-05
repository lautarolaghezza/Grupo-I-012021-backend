package ar.edu.unq.desapp.grupoi.backenddesappapi.services.valorationService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.valoration.ValorationRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.valoration.ValorationRepositoryImpl;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

//@Service
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
