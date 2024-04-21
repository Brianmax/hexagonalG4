package com.codigo.msregistro.application.controller;

import com.codigo.msregistro.application.aggregate.dto.PersonaDto;
import com.codigo.msregistro.application.impl.PersonaPortInImpl;
import com.codigo.msregistro.application.ports.in.PersonaPortIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {
    @Autowired
    private PersonaPortInImpl personaPortIn; // puerto de entrada
    @PostMapping("/create")
    public PersonaDto createController(@RequestParam String dni)
    {
        return personaPortIn.create(dni);
    }
}
