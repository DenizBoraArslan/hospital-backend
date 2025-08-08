package com.db.service;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;
import com.db.repository.IAppointmentRepository;
import com.db.service.interfaces.IAppointmentService;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    private IAppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAppointmentByPatientId(Long patientId) {
        return appointmentRepository.findAppointmentByPatientId(patientId) ;
    }

    @Override
    public List<Appointment> findAppointmentByDoctorId(Long doctorId) {
        return appointmentRepository.findAppointmentByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> findAppointmentByAppointmentDate(LocalDate appointmentDate) {
        return appointmentRepository.findAppointmentByAppointmentDate(appointmentDate);
    }

    @Override
    public List<Appointment> findAppointmentByStatus(AppointmentStatus status) {
        return appointmentRepository.findAppointmentByStatus(status);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
         appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

}
