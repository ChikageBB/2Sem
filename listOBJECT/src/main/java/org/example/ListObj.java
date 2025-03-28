package org.example;

public interface ListObj {


    void add(Object element);
    void add(Object element, int position);

    /**
     * Удаляет элемент из списка в позиции position и возвращает его
     * @return
     */

    Object remove(int position) throws IndexOutOfBoundsException;
    Integer size();
    Object get(int position) throws IndexOutOfBoundsException;

    /**
     *
     * сортирует структуру на месте
     *
     */
    //void sort(boolean flag);


}
