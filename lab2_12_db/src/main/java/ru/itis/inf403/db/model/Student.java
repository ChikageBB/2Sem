package ru.itis.inf403.db.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Student implements Serializable {

    private Integer id;
    private String name;
    private String lastName;
    private String fatherName;
    private String group;

}
