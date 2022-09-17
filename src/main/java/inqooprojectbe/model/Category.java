package inqooprojectbe.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private UUID categoryUUID;
    @OneToMany
    @JoinTable(
            name = "category_subcategory",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn( name = "subcategory_id")
    )
    private List<Subcategory> subcategories = Collections.emptyList();
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

    public UUID getCategoryUUID() {return categoryUUID;}

    public void setCategoryUUID(UUID categoryUUID) {
        this.categoryUUID = categoryUUID;
    }

    public void setSubcategories(List<Subcategory> subcategoryList) {
        this.subcategories = subcategoryList;
    }
}