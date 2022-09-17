package inqooprojectbe.repositories;

import inqooprojectbe.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Optional<Trainer> findByTrainerUUID(UUID trainerUUID);
}


