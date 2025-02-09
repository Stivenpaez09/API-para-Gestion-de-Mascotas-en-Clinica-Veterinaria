package com.clinica.veterinaria.controller;

import com.clinica.veterinaria.dto.MascotaDuenioDTO;
import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    
    private final IMascotaService mascoService;

    @Autowired
    public MascotaController(IMascotaService mascoService) {
        this.mascoService = mascoService;
    }
    
    @PostMapping ("/mascotas/crear")
    public ResponseEntity<String> saveMascota(@RequestBody Mascota masco){
        mascoService.saveMascota(masco);
        return ResponseEntity.status(HttpStatus.CREATED).body("Mascota creada correctamente");
    }
    
    @GetMapping ("/mascotas/traer")
    public ResponseEntity<List<Mascota>> getMascotas(){
        return ResponseEntity.ok(mascoService.getMascotas());
    }
    
    @GetMapping ("/mascotas/buscar")
    public ResponseEntity<Mascota> findMascota(@RequestParam Long id){
        return ResponseEntity.ok(mascoService.findMascota(id));
    }
    
    @PutMapping ("/mascotas/editar")
    public ResponseEntity<String> editMascota(@RequestBody Mascota masco){
        mascoService.editMascota(masco);
        return ResponseEntity.ok("Mascota editada correctamente");
    }
    
    @DeleteMapping ("/mascotas/eliminar")
    public ResponseEntity<String> deleteMascota(@RequestParam Long id){
        mascoService.deleteMascota(id);
        return ResponseEntity.ok("Mascota eliminada correctamente");
    }
    
    @GetMapping ("/mascotas/traer/especifica")
    public ResponseEntity<List<Mascota>> getEspecieRaza(@RequestParam String especie, @RequestParam String raza){
        return ResponseEntity.ok(mascoService.getEspecieRaza(especie, raza));
    }
    
    @GetMapping("/mascotas/traer/combinado")
    public ResponseEntity<MascotaDuenioDTO> getMascotaDuenio(@RequestParam Long id){
        return ResponseEntity.ok(mascoService.getMascotaDuenio(id));
    }
}