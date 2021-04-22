package model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Filter {
    private String filter_name;
    private FilterType type;

    public Filter(String filter, FilterType filterType) {
        this.filter_name = filter;
        this.type = filterType;
    }
}
