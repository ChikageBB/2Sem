package ru.itis.inf403.streamapi.model.booking;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

// ToDo 1. Вывести список гостиниц и кол-во бронирований женщинами
// ToDo 2. Вывести список гостиниц и кол-во бронирований мужчинами
// ToDo 3. Вывести процент бронирований из Самарской области
// ToDo 4. Вывести процент бронирований людьми в возрасте от 40 до 45 лет
// ToDo 5. Вывести список городов и кол-во бронирований по ним (город ~ г ...)
// ToDo 6. Сформировать Map ключ - гостиница, значение - список городов
// ToDo 7. Вывести процент уникальных людей (необходимо описать эквивалентность по полу, дате рождения)


public class MainBooking {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Bookings bookings = mapper.readValue(new File("D:\\itis\\javaProject\\2Sem\\lab2_07_streamapi\\src\\main\\java\\ru\\itis\\inf403\\streamapi\\model\\booking\\bookings.json"),  Bookings.class);

        printCountCity(bookings);
    }

    //Вывести количество
    public static void printCount(Bookings bookings){
        System.out.println(
        bookings
                .getBookings()
                .stream()
                .count()
        );
    }


    //Вывести кол-во гостей из москвы
    public static void printCountGuestFromMoscow(Bookings bookings){
        System.out.println(
        bookings
                .getBookings()
                .stream()
                .filter(p -> p.getPerson().getFromcity().contains("Москва"))
                .count()
        );
    }

    public static void printHotels(Bookings bookings) {
        Map<String, Integer> result =
                bookings.getBookings()
                .stream()
                .collect(Collectors.toMap(
                        b -> b.getHotel().getName(),
                        b -> 1,
                        (v1,v2) -> v1+v2)
                );
        result.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    public static void printHotelByWomen(Bookings bookings){
        Map<String, Integer> result =
                bookings.getBookings()
                        .stream()
                        .collect(Collectors.toMap(
                                b -> b.getHotel().getName(),
                                b -> 1,
                                Integer::sum
                        ));

        result.forEach((hotel, count) -> System.out.println(hotel + " : " + count));
    }

    public static void printHotelByMen(Bookings bookings){
        bookings.getBookings()
                .stream()
                .collect(Collectors.toMap(
                        b -> b.getHotel().getName(),
                        b -> 1,
                        Integer::sum
                ))
                .forEach((hotel, count) -> System.out.println(hotel + " : " + count));
    }

    public static void printPercentFromSamara(Bookings bookings){
        long count = bookings.getBookings()
                .stream()
                .filter(b -> b.getPerson().getFromcity() != null && b.getPerson().getFromcity().contains("Самарская область"))
                .count();

        System.out.println((double) count / bookings.getBookings().size() * 100 + " % ");
    }

    public static void printPercentPerson(Bookings bookings){

        long count = bookings.getBookings()
                .stream()
                .filter( b -> {
                            Date birth = b.getPerson().getBirthdate();
                            if (birth == null) return false;

                            LocalDate birthDate = birth.toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate();


                            LocalDate now = LocalDate.now();
                            int age = Period.between(birthDate, now).getYears();

                            return age >= 40 && age <= 45;
                    })
                .count();
        System.out.println((double) count / bookings.getBookings().size() * 100 + " % ");
    }
    public static void printCountCity(Bookings bookings){
            bookings.getBookings()
                    .stream()
                    .collect(Collectors.toMap(
                            b -> b.getPerson().getFromcity(),
                            b -> 1,
                            Integer::sum
                    ))
                    .forEach((city, count) -> System.out.println(city + " : " + count));
    }


    public static Map<String, List<String>> mapHotelCity(Bookings bookings){
        return bookings.getBookings()
                .stream()
                .collect(Collectors.groupingBy(
                        b -> b.getHotel().getName(),
                        Collectors.mapping(
                                b -> b.getPerson().getFromcity(),
                                Collectors.collectingAndThen(
                                        Collectors.toSet(),
                                        ArrayList::new
                                )
                        )
                ));
    }


    public static void printUniqPersonPercent(Bookings bookings){
       Set<String> uniqPerson =  bookings.getBookings()
                .stream()
                .map(b -> {
                    Person p = b.getPerson();
                    if (p == null || p.getGender() == null || p.getBirthdate() == null) return "";
                    return p.getGender() + " : " + p.getBirthdate();
                })
               .filter(set -> !set.isEmpty())
               .collect(Collectors.toSet());


        System.out.println((double)uniqPerson.size() * 100 / bookings.getBookings().size());
    }
}
