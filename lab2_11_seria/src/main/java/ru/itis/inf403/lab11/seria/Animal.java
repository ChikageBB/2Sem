package ru.itis.inf403.lab11.seria;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Animal implements Serializable {
    private String name;
    private Integer age;
    private AnimalType type;
    private AnimalClass category;


}
