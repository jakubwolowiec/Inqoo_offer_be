package inqooprojectbe.repositories;

import inqooprojectbe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryUUID(String categoryUUID);
}