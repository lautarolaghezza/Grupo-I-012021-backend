package ar.edu.unq.desapp.grupoi.backenddesappapi.services.valorationService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.valoration.Valoration;
import java.util.List;

public interface ValorationService {

    public List<Valoration> getValorations();
    public List<Valoration> getValorationsOf( String tconst);
    public void addValoration(Valoration valoration, UserAbs userAbs);
}
