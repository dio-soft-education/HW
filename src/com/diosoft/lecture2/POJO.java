package com.diosoft.lecture2;

//local code review (vtegza): why it is package local? @ 6/29/2015
//local code review (vtegza): please follow naming conventions, POJO - is wrong name for class @ 6/29/2015
class POJO implements Cloneable {
    private static final Position PERSON = Position.DIRECTOR;
    //local code review (vtegza): should have logical names (person not = position) @ 6/29/2015
    private Position person1 = Position.DEVELOPER;
    private Position person2 = Position.QA;

    //local code review (vtegza): should be public @ 6/29/2015
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

    //local code review (vtegza): take a look at requirements for Cloneable, you should not call supper @ 6/29/2015
    @Override
    public POJO clone() throws CloneNotSupportedException {
        return (POJO)super.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("POJO{").append("person1=").append(person1)
                .append(", person2=").append(person2).append('}');
        return sb.toString();
    }
}
