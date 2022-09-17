package inqooprojectbe.repositories;

import inqooprojectbe.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkshopRepository extends JpaRepository <Workshop, Long> {
    Workshop findByWorkshopUUID(UUID workshopUUID);
}
