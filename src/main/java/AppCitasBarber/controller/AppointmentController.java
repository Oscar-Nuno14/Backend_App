package AppCitasBarber.controller;

import AppCitasBarber.model.Appointment;
import AppCitasBarber.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}