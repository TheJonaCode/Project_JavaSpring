package com.projects.springmarket.domain;

public class Category {
    private int categoriaI;
    private String category;
    private boolean active;

    public int getCategoriaI() {
        return categoriaI;
    }

    public void setCategoriaI(int categoriaI) {
        this.categoriaI = categoriaI;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
