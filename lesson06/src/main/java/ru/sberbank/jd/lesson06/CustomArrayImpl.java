package ru.sberbank.jd.lesson06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * class CustomArrayImpl реализует интерфейс CustomArray.
 */

public class CustomArrayImpl<T> implements CustomArray<T> {
    private int size = 0;
    //Первый элемент.
    private Node<T> root;
    //Следующий или последний.
    private Node<T> last;

    /**
     * Generic object.
     */
    class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;
    }

    /**
     * Returns array size.
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks array is empty.
     *
     * @return true if success
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add single item.
     *
     * @param item - item for add
     *
     * @return true if success
     */
    @Override
    public boolean add(T item) {
        if (root == null) {
            Node<T> node = new Node<>();
            node.value = item;
            root = node;
            node.next = null;
            node.previous = null;
            last = node;
        } else {
            Node<T> node = new Node<>();
            node.value = item;
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
        size++;
        return true;
    }

    /**
     * Add all items.
     *
     * @param items - items for add
     *
     * @return true if success
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("Items must be not null");
        }
        for (Object item : items) {
            add((T) item);
        }
        return true;
    }

    /**
     * Add all items.
     *
     * @param items - items for add
     * @return true if success
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(Collection<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items must be not null");
        }
        for (T item : items) {
            add(item);
        }
        return true;
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    @Override
    public boolean addAll(int index, T[] items) {
        int maxIndex = size - 1;
        if (index > maxIndex || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
        if (items == null) {
            throw new IllegalArgumentException("Items must be not null");
        }
        Node<T> current = root;
        List<T> myList = new ArrayList<>();
        int i = 0;
        do {
            myList.add(i, current.value);
            i++;
        } while ((current = current.next) != null);
        int countAddItems = 0;
        for (T item : items) {
            myList.add(index + countAddItems, item);
            countAddItems++;
        }
        //Добавим элементы в правильном порядке обратно в массив
        root = null;
        size = 0;
        for (T t : myList) {
            add(t);
        }
        return true;
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @return T - item by index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Object[] customArray = this.toArray();
        return (T) customArray[index];
    }

    /**
     * Set item by index.
     *
     * @param index - index
     * @param item - item for sert
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T set(int index, T item) {
        if (index < 0 || index > this.getCapacity() - 1) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + this.getCapacity());
        }
        Object[] customArray = this.toArray();
        Object retObject = customArray[index];
        customArray[index] = item;
        this.rebuildMyArray(customArray);
        return (T) retObject;
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
        Object[] customArray = this.toArray();
        root = null;
        size = 0;
        int i = 0;
        for (Object t : customArray) {
            if (i != index) {
                add((T) t);
            }
            i++;
        }
    }

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    @Override
    public boolean remove(T item) {
        boolean b = false;
        int index = indexOf(item);
        if (index >= 0) {
            remove(index);
            b = true;
        }
        return b;
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    @Override
    public boolean contains(T item) {
        boolean ret = false;
        if (indexOf(item) >= 0) {
            ret = true;
        }
        return ret;
    }

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */
    @Override
    public int indexOf(T item) {
        int ret = -1;
        int counter = 0;
        Object[] customArray = this.toArray();
        for (Object t : customArray) {
            if (Objects.equals(item, t)) {
                ret = counter;
                break;
            }
            counter++;
        }
        return ret;
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    @Override
    public void ensureCapacity(int newElementsCount) {
        if (size != newElementsCount) {
            Object[] customArray = this.toArray();
            Object[] newCapacity = new Object[newElementsCount];
            for (int i = 0; i < newElementsCount; i++) {
                if (i <= size - 1) {
                    newCapacity[i] = customArray[i];
                } else {
                    newCapacity[i] = null;
                }
            }
            this.rebuildMyArray(newCapacity);
        }
    }

    /**
     * Get current capacity.
     *
     * @return current capacity
     */
    @Override
    public int getCapacity() {
        Object[] customArray = this.toArray();
        return customArray.length;
    }

    /**
     * Reverse list.
     */
    @Override
    public void reverse() {
        Object[] customArray = this.toArray();
        for (int i = 0; i < size / 2; i++) {
            T temp = (T) customArray[i];
            customArray[i] = customArray[size - 1 - i];
            customArray[size - 1 - i] = temp;
        }
        this.rebuildMyArray(customArray);
    }

    /**
     * Get copy of current array.
     *
     * @return T as Array
     */
    @Override
    public Object[] toArray() {
        int i = 0;
        Node<T> current = root;
        Object[] myArray = new Object[size];
        do {
            myArray[i] = current.value;
            i++;
        } while ((current = current.next) != null);
        return myArray;
    }

    /**
     * Get content in format '[ element1 element2 ... elenentN ] or [ ] if empty.
     *
     * @return array as string
     */
    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        Node<T> current = root;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(current.value).append(" ");
        } while ((current = current.next) != null);
        return sb.toString();
    }

    private void rebuildMyArray(Object[] items) {
        root = null;
        size = 0;
        for (Object t : items) {
            add((T) t);
        }
    }
}
