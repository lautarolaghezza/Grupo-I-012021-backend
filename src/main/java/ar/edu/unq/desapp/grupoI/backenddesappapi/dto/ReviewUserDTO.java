package ar.edu.unq.desapp.grupoi.backenddesappapi.dto;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewUserDTO {
    public String language;
    public Long userId;
    public boolean spoiler_Alert;
    private Platform platform;
    private Type_User type_user;
    private String location;

}
