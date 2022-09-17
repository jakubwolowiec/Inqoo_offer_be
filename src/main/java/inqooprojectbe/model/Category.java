package inqooprojectbe.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    @JoinTable(
            name = "category_subcategory",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn( name = "subcategory_id")
    )
    private List<Subcategory> subcategories = Collections.emptyList();

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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

    public void setSubcategories(List<Subcategory> subcategoryList) {
        this.subcategories = subcategoryList;
    }
}