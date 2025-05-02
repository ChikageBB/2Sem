package ru.itis.inf403.model.Set;

public interface ListObj<T> extends Iterable<T> {

    void add(T element);
    void add(T element, int position);

    /**
     * Удаляет элемент из списка в позиции position и возвращает его
     * @return
     */

    T remove(int position) throws IndexOutOfBoundsException;
    Integer size();
    T get(int position) throws IndexOutOfBoundsException;

    void print();
    boolean contains(T elem);
}
