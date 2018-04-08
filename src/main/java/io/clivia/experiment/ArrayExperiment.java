package io.clivia.experiment;

import java.util.Iterator;
import java.util.function.Consumer;

public class ArrayExperiment {

    public static class MyIterator implements Iterator<Integer[]> {
        private Integer[][] collection;
        private int i, j = 0;

        public MyIterator(Integer[][] collection) {
            this.collection = collection;
        }

        @Override
        public boolean hasNext() {
            return true;
//            if(i < collection.length &&  && j < collection[i].length) {
//
//            }
        }

        @Override
        public Integer[] next() {
            return new Integer[0];
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Integer[]> action) {

        }
    }

    public static void main(String[] args) {
        Iterator<Integer[]> it = new Iterator<Integer[]>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer[] next() {
                return new Integer[0];
            }
        };
    }
}
