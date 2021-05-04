package service.valorationService;

import model.user.User;
import model.valoration.Valoration;

import java.util.List;

public interface ValorationService {

    public List<Valoration> getValorations();
    public List<Valoration> getValorationsOf( String tconst);
    public void addValoration(Valoration valoration, User user);
}
