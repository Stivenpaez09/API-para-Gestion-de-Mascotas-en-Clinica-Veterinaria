package com.clinica.veterinaria.service;

import com.clinica.veterinaria.model.Duenio;
import com.clinica.veterinaria.repository.IDuenioRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DuenioService implements IDuenioService{
    
    private final IDuenioRepository duenioRepo;

    @Autowired
    public DuenioService(IDuenioRepository duenioRepo) {
        this.duenioRepo = duenioRepo;
    }

    
    @Transactional
    @Override
    public void saveDuenio(Duenio due) {
        if(due == null){
            throw new IllegalArgumentException("El objeto Mascota no puede ser nulo");
        }
        
        if(due.getCedula() ==null || due.getCedula().trim().isEmpty()){
            throw new IllegalArgumentException("La cedula del dueño es obligatorio");
        } 
        
        if(due.getNombre() ==null || due.getNombre().trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del dueño es obligatorio");
        } 
        
        if(due.getApellido() ==null || due.getApellido().trim().isEmpty()){
            throw new IllegalArgumentException("El apellido del nueño es obligatorio");
        } 
        
        if(due.getCelular() ==null || due.getCelular().trim().isEmpty()){
            throw new IllegalArgumentException("El celular del nueño es obligatorio");
        } 
        
        duenioRepo.save(due);
    }

    @Override
    public List<Duenio> getDuenios() {
        if(duenioRepo.findAll().isEmpty()){
            throw new IllegalArgumentException("No existen dueños en la base de datos");
        }
        return duenioRepo.findAll();
    }

    @Override
    public Duenio findDuenio(Long id) {
        return duenioRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("El dueño con ID " + id + " no fue encontrado en la base de datos"));
    }

    @Transactional
    @Override
    public void editDuenio(Duenio due) {
       this.findDuenio(due.getId());
       this.saveDuenio(due);
    }

    @Transactional
    @Override
    public void deleteDuenio(Long id) {
        this.findDuenio(id);
        duenioRepo.deleteById(id);
    }
    
}
