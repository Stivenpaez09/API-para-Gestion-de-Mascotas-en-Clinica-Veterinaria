package com.clinica.veterinaria.service;

import com.clinica.veterinaria.dto.MascotaDuenioDTO;
import com.clinica.veterinaria.model.Mascota;
import java.util.List;

public interface IMascotaService {
    public void saveMascota(Mascota masco);
    public List<Mascota>  getMascotas();
    public Mascota findMascota(Long id);
    public void editMascota(Mascota masco);
    public void deleteMascota(Long id);
    public List<Mascota> getEspecieRaza(String especie, String raza);
    public MascotaDuenioDTO getMascotaDuenio(Long id);
}
