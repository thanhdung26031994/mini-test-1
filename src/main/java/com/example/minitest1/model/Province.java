package com.example.minitest1.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 5, max = 45, message = "Độ dài từ 5-45 kí tự")
    private String name;

    public Province() {
    }

    public Province(Integer id, @Size(min = 5, max = 45) String name) {
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
}
