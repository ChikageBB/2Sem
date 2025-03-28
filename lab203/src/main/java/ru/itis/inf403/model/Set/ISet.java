package ru.itis.inf403.model.Set;

public interface ISet<T> {

    ///
    /// @Override добавление элемената в Set
    ///
    boolean add(T elem);

    ///
    /// @Override удаление элеменат из Set
    ///

    boolean remove(T elem);

    ///
    /// @Override печать Set
    ///

    void print();
    boolean contains(T elem);
    ///
    /// @Override возврат индекса элемента
    ///
    int getSize();
    int getIndex(T elem);

}
