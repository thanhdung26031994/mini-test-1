package com.example.minitest1.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String title;
    private String content;
    private String description;
    private String img;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Posts(Integer id, String code, String title, String content, String description, String img, Province province) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.description = description;
        this.img = img;
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Posts() {
    }

    public Posts(Integer id, String code, String title, String content, String description) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
