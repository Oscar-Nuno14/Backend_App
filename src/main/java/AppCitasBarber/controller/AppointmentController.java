package AppCitasBarber.controller;

import AppCitasBarber.model.Appointment;
import AppCitasBarber.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    // Crear cita
    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return service.save(appointment);
    }

    // Obtener todas las citas
    @GetMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }

    // Obtener cita por ID
    @GetMapping("/{id}")
    public Optional<Appointment> getById(@PathVariable String id) {
        return service.getById(id);
    }

    // Actualizar cita
    @PutMapping("/{id}")
    public Appointment update(
            @PathVariable String id,
            @RequestBody Appointment appointment
    ) {
        return service.update(id, appointment);
    }

    // Eliminar cita
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {

        service.delete(id);

        return "Cita eliminada correctamente";
    }
}