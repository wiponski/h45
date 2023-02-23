package kz.attractor.java.lesson44;

import java.time.LocalDate;

public class SampleDocument {
    private Integer id;
    private LocalDate data;
    private String text;


    public SampleDocument(Integer id, LocalDate data, String text) {
        this.id = id;
        this.data = data;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
