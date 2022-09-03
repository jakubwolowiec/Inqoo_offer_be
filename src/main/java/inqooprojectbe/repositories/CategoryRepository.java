package inqooprojectbe.repositories;

import inqooprojectbe.model.Category;
import inqooprojectbe.model.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<CategoryDTO> findByCategoryUUID(UUID categoryUUID);
}