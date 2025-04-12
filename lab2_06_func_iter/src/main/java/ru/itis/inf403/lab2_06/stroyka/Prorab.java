package ru.itis.inf403.lab2_06.stroyka;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Prorab implements Iterable<Boolean> {
    private Stroyka stroyka;

    private int stage;

    public Prorab(){
        this.stroyka = new Stroyka();
        this.stage = 0;
    }


    public Iterator<Boolean> iterator(){
        return new Iterator<Boolean>() {
            @Override
            public boolean hasNext() {
                return stage < 5;
            }

            @Override
            public Boolean next() {
                return switch (++stage){
                    case 1 -> stroyka.project();
                    case 2 -> stroyka.foundation();
                    case 3 -> stroyka.walls();
                    case 4 -> stroyka.roof();
                    case 5 -> stroyka.decoration();
                    default -> throw new NoSuchElementException();
                };
            }
        };
    }
}
