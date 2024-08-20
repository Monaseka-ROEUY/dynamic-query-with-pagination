package com.kaka.simplified.dynamic_query.entity;

public enum Position {
    GK("Goalkeeper"),

    // Defenders
    CB("Centre Back"),
    LB("Left Back"),
    RB("Right Back"),
    LWB("Left Wing Back"),
    RWB("Right Wing Back"),

    // Midfielders
    CDM("Central Defensive Midfielder"),
    CM("Central Midfielder"),
    CAM("Central Attacking Midfielder"),
    LM("Left Midfielder"),
    RM("Right Midfielder"),

    // Forwards
    LW("Left Winger"),
    RW("Right Winger"),
    CF("Centre Forward"),
    ST("Striker"),
    SS("Second Striker");

    private final String fullName;

    Position(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

}

