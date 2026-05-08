package AppCitasBarber.service;

import AppCitasBarber.model.Appointment;
import AppCitasBarber.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
