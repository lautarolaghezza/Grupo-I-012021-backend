package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filters;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter.*;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.platform.Platform;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.Type_User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterTest {

    LanguageFilter languageFilter;
    LocationFilter locationFilter;
    PlatformFilter platformFilter;
    SpoilerAlertFilter spoilerAlertFilter;
    TypeUserFilter typeUserFilter;
    @BeforeEach
    public void setUp() {
        languageFilter = new LanguageFilter("Spanish");
        locationFilter = new LocationFilter("Argentina");
        platformFilter = new PlatformFilter(Platform.NETFLIX);
        spoilerAlertFilter = new SpoilerAlertFilter(false);
        typeUserFilter = new TypeUserFilter(Type_User.COMMON);
    }

    @Test
    public void gettersTestlanguageFilter(){
        assertEquals("Spanish", languageFilter.getLanguage());
    }
    @Test
    public void gettersTestlocationFilter(){
        assertEquals("Argentina", locationFilter.getLocation());
    }
    @Test
    public void gettersTestplatformFilter(){
        assertEquals(Platform.NETFLIX, platformFilter.getPlatform());
    }
    @Test
    public void gettersTestspoilerAlertFilter(){
        assertEquals(false, spoilerAlertFilter.isSpoilerAlert());
    }
    @Test
    public void gettersTesttypeUserFilter(){
        assertEquals(Type_User.COMMON, typeUserFilter.getType_user());
    }
}
