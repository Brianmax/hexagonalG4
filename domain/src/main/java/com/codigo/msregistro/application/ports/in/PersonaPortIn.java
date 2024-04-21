package com.codigo.msregistro.application.ports.in;

import com.codigo.msregistro.application.aggregate.dto.PersonaDto;

public interface PersonaPortIn {
    // metodo crear (dni)
    // retornar los datos de la persona
    PersonaDto create(String dni);
    // buscar por dni
    PersonaDto findById(String dni);
    Boolean deleteById(String dni);
}
