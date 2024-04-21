package com.codigo.msregistro.application.impl;

import com.codigo.msregistro.application.aggregate.dto.PersonaDto;
import com.codigo.msregistro.application.ports.in.PersonaPortIn;
import com.codigo.msregistro.application.ports.out.PersonaPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaPortInImpl implements PersonaPortIn {
    @Autowired
    PersonaPortOut personaPortOut;
    @Override
    public PersonaDto create(String dni) {
        return personaPortOut.create_out(dni);
    }
    @Override
    public PersonaDto findById(String dni) {
        return personaPortOut.findById_out(dni);
    }

    @Override
    public Boolean deleteById(String dni) {
        return personaPortOut.deleteById_out(dni);
    }
}
