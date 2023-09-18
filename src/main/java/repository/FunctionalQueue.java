package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalQueue<T> implements IFunctionalQueue<T> {
    private final List<T> items = new ArrayList<>();

    @Override
    public void push(T item) {
        items.add(item);
    }

    @Override
    public T pop() {
        if (items.isEmpty()) {
            return null;
        }
        return items.remove(0);
    }

    @Override
    public List<T> filter(Function<T, Boolean> predicate) {
        List<T> returnList = new ArrayList<>();
        for (T item : items) {
            if (predicate.apply(item)) {
                returnList.add(item);
            }
        }
        return returnList;
    }

    @Override
    public <R> List<R> map(Function<T, R> mapper) {
        List<R> returnList = new ArrayList<>();
        for (T item : items) {
            R newItem = mapper.apply(item);
            returnList.add(newItem);
        }
        return returnList;
    }

    @Override
    public T find(Function<T, Boolean> predicate) {

        for (T item : items) {
            if (predicate.apply(item)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public int findIndex(Function<T, Boolean> predicate) {
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            if (predicate.apply(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T findLast(Function<T, Boolean> predicate) {
        for (int i = items.size() - 1; i >= 0; i--) {
            T item = items.get(i);
            if (predicate.apply(item)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public int findLastIndex(Function<T, Boolean> predicate) {
        for (int i = items.size() - 1; i >= 0; i--) {
            T item = items.get(i);
            if (predicate.apply(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void forEach(Function<T, Void> function) {
        for (T item : items) {
            function.apply(item);
        }
    }

    @Override
    public <C extends Comparable<C>> List<T> sort(Function<T, C> comparer) {
        List<T> sortedList = new ArrayList<>(items);
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = 1; j < sortedList.size() - i; j++) {
                T item1 = sortedList.get(j - 1);
                T item2 = sortedList.get(j);
                if (comparer.apply(item1).compareTo(comparer.apply(item2)) > 0) {
                    sortedList.set(j - 1, item2);
                    sortedList.set(j, item1);
                }
            }
        }
        return sortedList;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }


    @Override
    public String toString() {
        return items.toString();
    }
}
