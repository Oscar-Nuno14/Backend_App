package AppCitasBarber.service;

import AppCitasBarber.model.Appointment;
import AppCitasBarber.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    // GUARDAR CITA
    public Appointment save(Appointment appointment) {

        boolean ocupado =
                repository.existsByBarberAndDateAndTime(
                        appointment.getBarber(),
                        appointment.getDate(),
                        appointment.getTime()
                );

        if (ocupado) {

            throw new RuntimeException(
                    "Este horario ya está ocupado para el barbero"
            );
        }

        return repository.save(appointment);
    }

    // OBTENER TODAS LAS CITAS
    public List<Appointment> getAll() {

        List<Appointment> citas =
                repository.findAll();

        LocalDate hoy =
                LocalDate.now();

        // RECORRER CITAS
        for (Appointment cita : citas) {

            try {

                LocalDate fechaCita =
                        LocalDate.parse(
                                cita.getDate()
                        );

                // SI YA PASÓ
                if (
                        fechaCita.isBefore(hoy)
                        &&
                        cita.getStatus().equals("ACTIVA")
                ) {

                    cita.setStatus("COMPLETADA");

                    repository.save(cita);
                }

            } catch (Exception e) {

                System.out.println(
                        "Error procesando fecha"
                );
            }
        }

        return repository.findAll();
    }

    // ELIMINAR CITA
    public void delete(String id) {

        repository.deleteById(id);
    }
}