package com.diosoft.lecture2;

public class Main {
    public static void main(String[] args) {
        Person obj1 = new Person();
        Person obj2 = new Person(Position.QA);
        Person obj3 = null;
        final StringBuilder sb = new StringBuilder();

        try {
            obj3 = obj2.clone();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        //local code review (vtegza): take a look at String.format @ 19.07.15
        System.out.println(sb.append("obj1 = ").append(obj1).toString());
        sb.setLength(0);
        System.out.println(sb.append("obj2 = ").append(obj2).toString());
        sb.setLength(0);
        System.out.println(sb.append("obj3 = ").append(obj3).toString());
        sb.setLength(0);
        System.out.println(sb.append("obj1.equals(obj2) = ").append(obj1.equals(obj2)).toString());
        sb.setLength(0);
        System.out.println(sb.append("(obj1 == obj2) = ").append(obj1 == obj2).toString());
        sb.setLength(0);
        System.out.println(sb.append("(obj1.hashCode() == obj2.hashCode()) = ")
                .append(obj1.hashCode() == obj2.hashCode()).toString());
        sb.setLength(0);
        System.out.println(sb.append("obj2.equals(obj3) = ").append(obj2.equals(obj3)).toString());
        sb.setLength(0);
        System.out.println(sb.append("(obj2 == obj3) = ").append(obj2 == obj3).toString());
        sb.setLength(0);
        System.out.println(sb.append("(obj2.hashCode() == obj3.hashCode()) = ")
                .append((obj3 != null && obj2.hashCode() == obj3.hashCode())).toString());
    }
}
