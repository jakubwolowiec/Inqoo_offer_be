package inqooprojectbe.repositories;

import inqooprojectbe.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository <Workshop, Long> {
    Workshop findByWorkshopUUID(String workshopUUID);
}
