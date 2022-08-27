package inqooprojectbe.repositories;

import inqooprojectbe.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkshopRepository extends JpaRepository <Workshop, Long> {
    Optional<Workshop> findByName(String name);
    Optional<Workshop> findByWorkshopUUID(UUID workshopUUID);
}
