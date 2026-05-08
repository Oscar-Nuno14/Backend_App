package AppCitasBarber.service;

import AppCitasBarber.model.Appointment;
import AppCitasBarber.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    // Guardar cita
    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    // Obtener todas las citas
    public List<Appointment> getAll() {
        return repository.findAll();
    }

    // Obtener cita por ID
    public Optional<Appointment> getById(String id) {
        return repository.findById(id);
    }

    // Actualizar cita
    public Appointment update(String id, Appointment appointment) {

        appointment.setId(id);

        return repository.save(appointment);
    }

    // Eliminar cita
    public void delete(String id) {
        repository.deleteById(id);
    }
}