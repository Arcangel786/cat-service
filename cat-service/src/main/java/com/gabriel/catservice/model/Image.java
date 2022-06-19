package com.gabriel.catservice.model;

public class Image {
    private String id;
    private String url;
    private String sub_id;
    private String created_at;
    private String original_filename;
    private Category[] categories;
    private CatBreed[] breeds;

    public Image() {
    }

    public Image(String id, String url, String sub_id, String created_at, String original_filename, Category[] categories, CatBreed[] breeds) {
        this.id = id;
        this.url = url;
        this.sub_id = sub_id;
        this.created_at = created_at;
        this.original_filename = original_filename;
        this.categories = categories;
        this.breeds = breeds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getOriginal_filename() {
        return original_filename;
    }

    public void setOriginal_filename(String original_filename) {
        this.original_filename = original_filename;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public CatBreed[] getBreeds() {
        return breeds;
    }

    public void setBreeds(CatBreed[] breeds) {
        this.breeds = breeds;
    }
}
