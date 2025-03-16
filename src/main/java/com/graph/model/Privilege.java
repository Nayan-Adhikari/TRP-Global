package com.graph.model;

public class Privilege {
    private String privilegeId;
    private String name;

    public Privilege(String privilegeId, String name) {
        this.privilegeId = privilegeId;
        this.name = name;
    }

    public String getPrivilegeId() { return privilegeId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Privilege(" + privilegeId + ", " + name+")";
    }
}