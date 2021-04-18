package model.reviews;

import model.Plataform;

import java.time.LocalDate;

public class PublicReview extends Review {
    private String nick;
    private int user_id;
    private String location;

    public PublicReview(String resume,
                        String extendedText,
                        int rating,
                        LocalDate date,
                        Plataform plataform,
                        String language,
                        String nick,
                        int user_id,
                        String location) {
        super(resume,
                extendedText,
                rating,
                date,
                plataform,
                language);
        this.nick = nick;
        this.user_id = user_id;
        this.location = location;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
