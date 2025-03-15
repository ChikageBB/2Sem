package ru.itis.inf403.set403.Set;

public interface ListObj<T> {

    void add(T element);
    void add(T element, int position);

    /**
     * Удаляет элемент из списка в позиции position и возвращает его
     * @return
     */

    T remove(int position) throws IndexOutOfBoundsException;
    Integer size();
    T get(int position) throws IndexOutOfBoundsException;

    /**
     *
     * сортирует структуру на месте
     *
     */
    //void sort(boolean flag);

    boolean contains(T elem);
}
