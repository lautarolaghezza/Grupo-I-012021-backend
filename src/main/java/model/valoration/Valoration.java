package model.valoration;

import lombok.Getter;

@Getter
public class Valoration {
    private String tconst;
    private boolean like;
    private long userId;

    public Valoration(String tconst, boolean like, long userId) {
        this.tconst = tconst;
        this.like = like;
        this.userId = userId;
    }
}
