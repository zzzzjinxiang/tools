package com.company;

public enum TypeEnum {
    STRING("java.lang.String", String.class),
    INTEGER("java.lang.Integer",Integer.class),
    LONG("java.lang.Long", Long.class)
    ;
    private final String type;
    private final Class clazz;

    public String getType() {
        return type;
    }

    public Class getClazz() {
        return clazz;
    }

    TypeEnum(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }
}
