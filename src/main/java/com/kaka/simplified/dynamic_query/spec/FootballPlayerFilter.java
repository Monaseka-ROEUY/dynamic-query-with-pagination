package com.kaka.simplified.dynamic_query.spec;

import com.kaka.simplified.dynamic_query.entity.Position;
import lombok.Data;

@Data
public class FootballPlayerFilter {
    private String firstName;
    private String lastName;
    private Position position;
    private Integer jerseyNumber;
}
