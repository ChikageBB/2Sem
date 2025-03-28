package ru.itis.inf403.model;

import ru.itis.inf403.model.genericsList.*;

import java.io.FileNotFoundException;

///
///     - По списку вывести в упорядоченном виде парковые номера и время начала движения
///     - По списку вывести в упорядоченном виде номера маршрутов, время начала и окончнания движения маршрута
///     - По списку вывести кол-во разных маршрутов
///     - По списку вывести кол-во разных транспортных средств
///     - По списку вывести номер маршрута и кол-во транспортных средств на нем
///



public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        TransportService transportService = new TransportService("D:\\itis\\javaProject\\2Sem\\lab203\\transport.csv");


        ListObj<Transport> list = transportService.readAll();
        list.print();

        transportService.printWorkTime();

        System.out.println("-----------------------");

        transportService.printUniqRouteNumber();

        System.out.println("-----------------------");

        transportService.printUniqTransport();

        System.out.println("-----------------------");

        transportService.printCntTransp();

    }
}
