package com.diosoft.lecture2;

class POJO implements Cloneable {
    private static final Position PERSON = Position.DIRECTOR;
    private Position person1 = Position.DEVELOPER;
    private Position person2 = Position.QA;

    POJO() {}

    POJO(Position person) {
        setPerson1(person);
    }

    POJO(Position person1, Position person2) {
        setPerson1(person1);
        setPerson1(person2);
    }

    public static Position getPERSON() {
        return PERSON;
    }

    public Position getPerson1() {
        return person1;
    }

    public Position getPerson2() {
        return person2;
    }

    public void setPerson1(Position person1) {
        this.person1 = person1;
    }

    public void setPerson2(Position person2) {
        this.person2 = person2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof POJO)) return false;

        POJO pojo = (POJO) o;

        return (getPerson1() == pojo.getPerson1()) && (getPerson2() == pojo.getPerson2());
    }

    @Override
    public int hashCode() {
        int result = getPerson1() != null ? getPerson1().hashCode() : 0;
        result = 31 * result + (getPerson2() != null ? getPerson2().hashCode() : 0);
        return result;
    }

    @Override
    public POJO clone() throws CloneNotSupportedException {
        return (POJO)super.clone();
    }

    @Override
    public String toString() {
        return "POJO{" +
                "person1=" + person1 +
                ", person2=" + person2 +
                '}';
    }
}
