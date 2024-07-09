package com.alura.service;

import com.alura.dto.FraseDTO;
import com.alura.modelos.Frase;
import com.alura.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repository;

    public FraseDTO obtenerFraseAleatoria() {
        Frase frase = repository.obtenerFraseAleatoria();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(),
                frase.getPersonaje(), frase.getPoster());
    }
}
