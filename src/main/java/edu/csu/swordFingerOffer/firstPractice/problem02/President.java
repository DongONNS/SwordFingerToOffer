package edu.csu.swordFingerOffer.firstPractice.problem02;

/**
 * 问题拓展： 定义一个表示总统的类型President,可以从改类型继承出FrechPresident和AmericanPresident，
 * 这些派生类只能产生一个实例。
 * Created by fengyuwusong on 2018/1/15 15:42.
 */
class President {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class FrenchPresident extends President {
    private FrenchPresident() {
    }

    private static class Nested {
        private final static FrenchPresident instance = new FrenchPresident();
    }

    public static FrenchPresident getInstance() {
        return Nested.instance;
    }

    public static void main(String[] args) {
        FrenchPresident s1 = FrenchPresident.getInstance();
        FrenchPresident s2 = FrenchPresident.getInstance();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

    }
}

class AmericanPresident {
    private AmericanPresident() {
    }

    public static AmericanPresident getInstance() {
        return Nested.instance;
    }

    private static class Nested {

        public static final AmericanPresident instance = new AmericanPresident();
    }

    public static void main(String[] args) {
        AmericanPresident s1 = AmericanPresident.getInstance();
        AmericanPresident s2 = AmericanPresident.getInstance();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

    }

}