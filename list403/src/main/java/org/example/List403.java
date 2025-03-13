package org.example;

public interface List403 {


    void add(Integer element);
    void add(Integer element, int position);

    /**
     * Удаляет элемент из списка в позиции position и возвращает его
     * @return
     */

Integer remove(int position) throws IndexOutOfBoundsException;
    Integer size();
    Integer get(int position) throws IndexOutOfBoundsException;

    /**
     *
     * сортирует структуру на месте
     *
     */
    void sort(boolean flag);


}
