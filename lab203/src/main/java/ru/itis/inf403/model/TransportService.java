package ru.itis.inf403.model;

import ru.itis.inf403.model.genericsList.*;
import ru.itis.inf403.model.Set.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransportService {

    private File fileName;

    public TransportService(String fileName){
        this.fileName = new File(fileName);
    }

    public ListObj<Transport> readAll() throws FileNotFoundException{
        try {

            Scanner sc = new Scanner(fileName);
            ListObj<Transport> result = new ListExample<>();

            if (sc.hasNextLine()){
                sc.nextLine();
            }

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] str = line.split(";");

                result.add(
                        switch (str[0]){
                            case "bus" -> new Bus(str[1], str[2], str[3], str[4]);
                            case "tram" -> new Tram(str[1], str[2], str[3], str[4]);
                            case "trolleybus" -> new Trolleybus(str[1], str[2], str[3], str[4]);
                            default -> null;
                        }
                );
            }
            sc.close();
            return result;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }


    public ListObj<Bus> readAllBus() throws FileNotFoundException{
        Scanner sc = new Scanner(fileName);
        ListObj<Bus> result = new ListExample<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("bus")){
                result.add(new Bus(str[1], str[2], str[3], str[4]));
            }
        }

        sc.close();
        return result;
    }

     public ListObj<Trolleybus> readAllTrolleybus() throws FileNotFoundException{
        Scanner sc = new Scanner(fileName);
        ListObj<Trolleybus> result = new ListExample<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("trolleybus")){
                result.add(new Trolleybus(str[1], str[2], str[3], str[4]));
            }
        }

        sc.close();
        return result;
    }

     public ListObj<Tram> readAllTram() throws FileNotFoundException{
        Scanner sc = new Scanner(fileName);
        ListObj<Tram> result = new ListExample<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("tram")){
                result.add(new Tram(str[1], str[2], str[3], str[4]));
            }
        }
        sc.close();
        return result;
    }

    private ListObj<Transport> sortred() throws FileNotFoundException{
        ListObj<Transport> list = readAll();

        if (list == null || list.size() == 0){
            return list;
        }


        for (int i = 0; i < list.size() - 1; i++){
            for (int j = i + 1; j < list.size(); j++ ){
                int num1 = Integer.parseInt(list.get(i).routeNumber);
                int num2 = Integer.parseInt(list.get(j).routeNumber);

                if (num1 > num2){
                    list.swap(i, j);
                }
            }
        }
        return list;
    }

    public void printWorkTimeBegin() throws FileNotFoundException{
        ListObj<Transport> list = sortred();

        if (list == null || list.size() == 0){
            System.out.println("Ошибка");
            return;
        }

        for (int i = 0; i < list.size(); i++){
            Transport t = list.get(i);
            System.out.println("Номер: " + t.routeNumber + " | Время начала : " + t.workTimeBegin);
        }
    }

    public void printWorkTime() throws FileNotFoundException{
        ListObj<Transport> list = sortred();

        if (list == null || list.size() == 0){
            System.out.println("Ошибка");
            return;
        }

        for (int i = 0; i < list.size(); i++){
            Transport t = list.get(i);
            System.out.println("Номер: " + t.routeNumber + " | Время начала : " + t.workTimeBegin + " | Время окончания : " + t.workTimeEnd );
        }
    }

    public void printUniqRouteNumber() throws FileNotFoundException{

        ListObj<Transport> list = readAll();
        ISet<String> set = new SetExample<>();

        for (int i = 0; i < list.size(); i++){
            set.add(list.get(i).getRouteNumber());
        }

        System.out.println("Уникальные номера маршрутов: ");
        set.print();
        System.out.println("Количество уникальных маршрутов: " + set.getSize());
    }


    public void printUniqTransport() throws FileNotFoundException{
        ListObj<Transport> list = readAll();
        ISet<String> set = new SetExample<>();

        for (int i = 0; i < list.size(); i++){
            set.add(list.get(i).getNumber());
        }

        System.out.println("Уникальные транспортные средства: ");
        set.print();
        System.out.println("Количество транспортных средств: " + set.getSize());

    }

    public void printCntTransp() throws FileNotFoundException{
        ListObj<Transport> list = readAll();

        if (list == null || list.size() == 0){
            System.out.println("Список пуст");
            return;
        }

        ISet<Transport> processedTransport = new SetExample<>();
        ListObj<RouteCount> routeCounts = new ListExample<>();

        for (int i = 0; i < list.size(); i++){
            Transport t = list.get(i);

            if (processedTransport.contains(t)){
                continue;
            }

            int count = 0;
            String currentRoute = t.getRouteNumber();

            for (int j = 0; j < list.size(); j++){
                Transport other = list.get(j);

                if (currentRoute.equals(other.getRouteNumber())){
                    count++;
                    processedTransport.add(other);
                }
            }
            routeCounts.add(new RouteCount(currentRoute, count));
        }

        for (int i = 0; i < routeCounts.size(); i++){
            RouteCount rc = routeCounts.get(i);
            System.out.println("Маршрут " + rc.routeNumber + ": " + rc.count + " шт.");
        }
    }

    private static class RouteCount{
        String routeNumber;
        int count;

        RouteCount(String routeNumber, int count){
            this.routeNumber = routeNumber;
            this.count = count;
        }
    }

}
