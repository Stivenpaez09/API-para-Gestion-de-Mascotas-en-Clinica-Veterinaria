package com.clinica.veterinaria.controller;

import com.clinica.veterinaria.model.Duenio;
import com.clinica.veterinaria.service.IDuenioService;
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
public class DuenioController {
    private final IDuenioService dueService;

    @Autowired
    public DuenioController(IDuenioService dueService) {
        this.dueService = dueService;
    }
    
    @PostMapping ("/duenios/crear")
    public ResponseEntity<String> saveDuenio(@RequestBody Duenio due){
        dueService.saveDuenio(due);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dueño creado correctamente");
    }
    
    @GetMapping ("/duenios/traer")
    public ResponseEntity<List<Duenio>> getDuenios(){
        return ResponseEntity.ok(dueService.getDuenios());
    }
    
    @GetMapping ("/duenios/buscar")
    public ResponseEntity<Duenio> findDuenio(@RequestParam Long id){
        return ResponseEntity.ok(dueService.findDuenio(id));
    }
    
    @PutMapping ("/duenios/editar")
    public ResponseEntity<String> editMascota(@RequestBody Duenio due){
        dueService.editDuenio(due);
        return ResponseEntity.ok("Dueño editado correctamente");
    }
    
    @DeleteMapping ("/duenios/eliminar")
    public ResponseEntity<String> deleteDuenio(@RequestParam Long id){
        dueService.deleteDuenio(id);
        return ResponseEntity.ok("Dueño eliminado correctamente");
    }
}
