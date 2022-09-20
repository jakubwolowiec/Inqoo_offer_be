package inqooprojectbe.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String categoryUUID;
    @OneToMany
    @JoinTable(
            name = "category_subcategory",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn( name = "subcategory_id")
    )
    private List<Subcategory> subcategories = new ArrayList<>();
    private String background;
    public Category(String name, String description, String background) {
        this.name = name;
        this.description = description;
        this.background = background;
    }

    public String getBackground() {
        return background;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public String getCategoryUUID() {return categoryUUID;}

    public void setCategoryUUID(String categoryUUID) {
        this.categoryUUID = categoryUUID;
    }

    public void setSubcategories(List<Subcategory> subcategoryList) {
        this.subcategories = subcategoryList;
    }
    public Subcategory addSubcategory(Subcategory subcategory){
        this.subcategories.add(subcategory);
        return subcategory;
    }
}