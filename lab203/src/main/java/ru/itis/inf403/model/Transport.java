package ru.itis.inf403.model;


import java.util.Objects;

public abstract class Transport{
    protected String number;
    protected String routeNumber;
    protected String workTimeBegin;
    protected String workTimeEnd;
    

    public Transport(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        this.number = number;
        this.routeNumber = routeNumber;
        this.workTimeBegin = workTimeBegin;
        this.workTimeEnd = workTimeEnd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getWorkTimeBegin() {
        return workTimeBegin;
    }

    public void setWorkTimeBegin(String workTimeBegin) {
        this.workTimeBegin = workTimeBegin;
    }

    public String getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setWorkTimeEnd(String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, routeNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Transport transport = (Transport) obj;
        return
               Objects.equals(number, transport.number) &&
               Objects.equals(routeNumber, transport.routeNumber);

    }
}