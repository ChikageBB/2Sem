package ru.itis.inf403.model;

public class Tram extends Transport{

    public Tram(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString(){
        return "tram: " + number + " | " + routeNumber + " | " + workTimeBegin + " | " + workTimeEnd + "\n";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
