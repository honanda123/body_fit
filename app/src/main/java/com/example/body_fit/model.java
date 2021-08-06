package com.example.body_fit;

import com.google.firebase.database.annotations.NotNull;

public class model {
    @NotNull
    private final String title;
    @NotNull
    private final String description;
    private final int img;
    @NotNull
    public final String getTitle() {
        return this.title;
    }
    @NotNull
    public final String getDescription() {
        return this.description;
    }
    public final int getImg() {
        return this.img;
    }
    public model(@NotNull String title, @NotNull String description, int img) {
        super();
        this.title = title;
        this.description = description;
        this.img = img;
    }
}
