package repository.valoration;

import exceptions.TitleHasBeenAddedException;
import exceptions.ValorationHasBeenAddedException;
import model.user.User;
import model.valoration.Valoration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public

class ValorationRepositoryImpl implements ValorationRepository  {

    private List<Valoration> valorations;

    public ValorationRepositoryImpl() {
        this.valorations = new ArrayList<>();
    }


    @Override
    public List<Valoration> getValorations() {
        return this.valorations;
    }

    @Override
    public List<Valoration> getValorationsOf(String tconst) {
        return this.valorations
                .stream()
                .filter(v-> v.getTconst()
                        .equalsIgnoreCase(tconst))
                .collect(Collectors.toList());
    }

    @Override
    public void generateValoratio(Valoration valoration, User user) {
        boolean isAdded = this.valorations
                .stream()
                .anyMatch(t -> t.getTconst()
                        .equals(valoration.getTconst()) &&
                        valoration.getUserId() == user.getUserId());
        if (isAdded) throw new ValorationHasBeenAddedException();
            valorations.add(valoration);
    }

}
