package com.lib.java.iterator;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.iterator
 * desc    :
 */
public class Name implements Container {
    private final String[] names = {"A", "B", "C", "D"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
