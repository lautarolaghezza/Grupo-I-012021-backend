package repository.valoration;

import model.user.User;
import model.valoration.Valoration;

import java.util.List;

public interface ValorationRepository {

    public List<Valoration> getValorations();
    public List<Valoration> getValorationsOf(String tconst);
    public void generateValoratio(Valoration valoration, User user);
}
