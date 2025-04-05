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

    ///
    /// @Override возврат индекса элемента
    ///

    int getIndex(T elem);

}
