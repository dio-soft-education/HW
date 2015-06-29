package com.diosoft.lecture2;

public class Person implements Cloneable {
    private static final Position POSITION = Position.DIRECTOR;
    private Position position1 = Position.DEVELOPER;
    private Position position2 = Position.QA;

    public Person() {}

    public Person(Position position) {
        setPosition1(position);
    }

    public Person(Position position1, Position position2) {
        setPosition1(position1);
        setPosition2(position2);
    }

    public static Position getPosition() {
        return POSITION;
    }

    public Position getPosition1() {
        return position1;
    }

    public Position getPosition2() {
        return position2;
    }

    public void setPosition1(Position position) {
        this.position1 = position;
    }

    public void setPosition2(Position position) {
        this.position2 = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person obj = (Person) o;

        return (getPosition1() == obj.getPosition1()) && (getPosition2() == obj.getPosition2());
    }

    @Override
    public int hashCode() {
        int result = getPosition1() != null ? getPosition1().hashCode() : 0;
        result = 31 * result + (getPosition2() != null ? getPosition2().hashCode() : 0);
        return result;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person obj = new Person();
        obj.setPosition1(this.getPosition1());
        obj.setPosition2(this.getPosition2());
        return obj;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Person{").append("person1=").append(position1)
                .append(", person2=").append(position2).append('}');
        return sb.toString();
    }
}
