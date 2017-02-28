package com.hjy.chapter3.enums;

/**
 * Created by hjy on 17-2-27.
 */
public enum Sex {
    MALE(1,"男"),FEMALE(2,"女");
    private int id;
    private String name;

    Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Sex getSex(int id){
        if (id==1){
            return MALE;
        }else if (id==2){
            return FEMALE;
        }
        return null;
    }
}
