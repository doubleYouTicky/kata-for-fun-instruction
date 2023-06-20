package com.kata.kataforfunjava.models;

import java.util.Optional;

public class KataForFunModel {
    public interface NamedPrimitive {
        String getTypeName();
    }

    public interface DivisiblePrimitive extends NamedPrimitive {
        String getDivisibleResult(int inputNumber);
    }

    public interface MatchablePrimitive extends NamedPrimitive {
        boolean match(char c);
    }

    public abstract sealed static class Primitive implements MatchablePrimitive permits Primitive3, Primitive5, Primitive7 {
        protected final int divisor;
        protected final String typeName;

        public Primitive(int divisor, String typeName) {
            this.divisor = divisor;
            this.typeName = typeName;
        }

        @Override
        public boolean match(char c) {
            return Optional.of(Character.getNumericValue(c))
                    .filter(n -> n == divisor)
                    .isPresent();
        }

        @Override
        public String getTypeName() {
            return typeName;
        }
    }

    public static final class Primitive3 extends Primitive implements DivisiblePrimitive {
        public Primitive3() {
            super(3, "Kata");
        }

        @Override
        public String getDivisibleResult(int inputNumber) {
            return inputNumber % divisor == 0 ? typeName : "";
        }
    }

    public static final class Primitive5 extends Primitive implements DivisiblePrimitive {
        public Primitive5() {
            super(5, "For");
        }

        @Override
        public String getDivisibleResult(int inputNumber) {
            return inputNumber % divisor == 0 ? typeName : "";
        }
    }

    public static final class Primitive7 extends Primitive {
        public Primitive7() {
            super(7, "Fun");
        }
    }
}
