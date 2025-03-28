package ru.itis.inf403.model;

public class Trolleybus extends Transport{

    public Trolleybus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString(){
        return "trolleybus: " + number + " | " + routeNumber + " | " + workTimeBegin + " | " + workTimeEnd + "\n";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
