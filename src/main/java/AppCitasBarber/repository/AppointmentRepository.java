package AppCitasBarber.repository;

import AppCitasBarber.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    Optional<Appointment> findById(String id);

}