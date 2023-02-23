package kz.attractor.java.lesson44;

import java.time.LocalDate;

public class CustomerData {
    private Integer id;
    private String name;

    public CustomerData(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
