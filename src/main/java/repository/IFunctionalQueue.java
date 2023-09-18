package repository;

import java.util.List;
import java.util.function.Function;

public interface IFunctionalQueue<T> {
    void push(T item);

    T pop();

    List<T> filter(Function<T, Boolean> predicate);

    <R> List<R> map(Function<T, R> mapper);

    T find(Function<T, Boolean> predicate);

    int findIndex(Function<T, Boolean> predicate);

    T findLast(Function<T, Boolean> predicate);

    int findLastIndex(Function<T, Boolean> predicate);

    void forEach(Function<T, Void> function);

    <C extends Comparable<C>> List<T> sort(Function<T, C> comparer);

    boolean isEmpty();

    int size();
}
