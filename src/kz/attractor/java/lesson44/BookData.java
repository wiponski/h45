package kz.attractor.java.lesson44;

import java.time.LocalDate;

public class BookData {
    private Integer id;
    private LocalDate data;
    private String name;

    public BookData(Integer id, LocalDate data, String name) {
        this.id = id;
        this.data = data;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookData{" +
                "id=" + id +
                ", data=" + data +
                ", name='" + name + '\'' +
                '}';
    }
}
