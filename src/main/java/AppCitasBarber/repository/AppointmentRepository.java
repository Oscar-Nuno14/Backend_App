package AppCitasBarber.repository;

import AppCitasBarber.model.Appointment;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    Optional<Appointment> findById(String id);

    // Buscar citas por fecha y barbero
    List<Appointment> findByDateAndBarber(
            String date,
            String barber
    );

    // Validar si ya existe una cita
    Optional<Appointment> findByDateAndTimeAndBarber(
            String date,
            String time,
            String barber
    );
}