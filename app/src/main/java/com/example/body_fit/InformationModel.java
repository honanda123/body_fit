package com.example.body_fit;

public class InformationModel {
    String id;
    String name;
    String img;
    String overview;

    public InformationModel(String id, String name, String img, String overview) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
