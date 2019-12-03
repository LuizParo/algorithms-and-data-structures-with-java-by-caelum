package br.com.caelum.model;

import java.util.Objects;

import static java.lang.String.format;
import static java.util.Locale.US;

public final class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return format(US, "Student{name='%s'}", this.name);
    }
}
