package ar.edu.unq.desapp.grupoi.backenddesappapi.dto;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReviewUserDTO {
    public String reviewdtype;
    public long id;
    public Date date;
    public String extended_text;
    public String language;
    public float rating;
    public String resume;
    public String tittle_tconst;
    public Long user_id;
    public Integer critic_id;
    public boolean spoiler_alert;
    private String type_user;
    private String nick;
    private Platform platform;
    private String location;
}
