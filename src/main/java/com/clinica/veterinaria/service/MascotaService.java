package com.clinica.veterinaria.service;

import com.clinica.veterinaria.dto.MascotaDuenioDTO;
import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.repository.IMascotaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MascotaService implements IMascotaService{

    private final IMascotaRepository mascoRepo;
    
    @Autowired
    public MascotaService(IMascotaRepository mascoRepo) {
        this.mascoRepo = mascoRepo;
    }    
    
    @Transactional
    @Override
    public void saveMascota(Mascota masco) {
        if(masco == null){
            throw new IllegalArgumentException("El objeto Mascota no puede ser nulo");
        } 
        
        if(masco.getNombre() ==null || masco.getNombre().trim().isEmpty()){
            throw new IllegalArgumentException("El nombre de la mascota es obligatorio");
        } 
        
        if(masco.getEspecie() == null || masco.getEspecie().trim().isEmpty()){
            throw new IllegalArgumentException("La especie de la mascota es obligatorio");
        } 
        
        if(masco.getRaza() == null || masco.getRaza().trim().isEmpty()){
            throw new IllegalArgumentException("La raza de la mascota es obligatorio");
        } 
        
        if(masco.getColor() == null || masco.getColor().trim().isEmpty()){
            throw new IllegalArgumentException("El color de la mascota es obligatorio");
        }
        
        mascoRepo.save(masco);
    }

    @Override
    public List<Mascota> getMascotas() {
        if(mascoRepo.findAll().isEmpty()){
            throw new IllegalArgumentException("No existen mascotas en la base de datos");
        }
        return mascoRepo.findAll();
    }

    @Override
    public Mascota findMascota(Long id) {
        return mascoRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("La mascota con ID " + id + " no fue encontrado en la base de datos"));

    }

    @Transactional
    @Override
    public void editMascota(Mascota masco) {
        this.findMascota(masco.getId());
        this.saveMascota(masco);
    }

    @Transactional
    @Override
    public void deleteMascota(Long id) {
        this.findMascota(id);
        mascoRepo.deleteById(id);
    }

    @Override
    public List<Mascota> getEspecieRaza(String especie, String raza) {
        List<Mascota> listaEncontrados = new ArrayList<>();
        List<Mascota> listaMascotas = this.getMascotas();
        for(Mascota masco: listaMascotas){
            if(masco.getEspecie().trim().equalsIgnoreCase(especie)){
                if(masco.getRaza().trim().equalsIgnoreCase(raza)){
                    listaEncontrados.add(masco);
                }
            }
        }
        
        if(listaEncontrados.isEmpty()){
            throw new IllegalArgumentException("No se encontraron mascotas en la base de datos con esas caracteristicas");
        }
        
        return listaEncontrados;
    }

    @Override
    public MascotaDuenioDTO getMascotaDuenio(Long id) {
        MascotaDuenioDTO mascoDTO = new MascotaDuenioDTO();
        Mascota masco = this.findMascota(id);
        mascoDTO.setNombreMascota(masco.getNombre());
        mascoDTO.setEspecie(masco.getEspecie());
        mascoDTO.setRaza(masco.getRaza());
        mascoDTO.setNombreDuenio(masco.getUnDuenio().getNombre());
        mascoDTO.setApellidoDuenio(masco.getUnDuenio().getApellido());
        return mascoDTO;
    }
    
}
