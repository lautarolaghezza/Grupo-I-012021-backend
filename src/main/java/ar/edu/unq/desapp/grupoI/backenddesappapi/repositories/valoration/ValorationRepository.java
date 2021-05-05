package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.valoration;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.User;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;

import java.util.List;

public interface ValorationRepository {

    public List<Valoration> getValorations();
    public List<Valoration> getValorationsOf(String tconst);
    public void generateValoratio(Valoration valoration, User user);
}
