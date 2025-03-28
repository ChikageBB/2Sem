package ru.itis.inf403.model;

public class Bus extends Transport{

    public Bus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString(){
        return "bus: " + number + " | " + routeNumber + " | " + workTimeBegin + " | " + workTimeEnd + "\n";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

