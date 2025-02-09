package com.clinica.veterinaria.service;

import com.clinica.veterinaria.model.Duenio;
import java.util.List;

public interface IDuenioService {
    public void saveDuenio(Duenio due);
    public List<Duenio>  getDuenios();
    public Duenio findDuenio(Long id);
    public void editDuenio(Duenio due);
    public void deleteDuenio(Long id);
}
