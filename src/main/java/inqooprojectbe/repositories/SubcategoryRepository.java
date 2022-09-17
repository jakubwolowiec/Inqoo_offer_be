package inqooprojectbe.repositories;

import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.SubcategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    List<SubcategoryDTO> findBySubcategoryUUID(UUID SubcategoryUUID);
}
