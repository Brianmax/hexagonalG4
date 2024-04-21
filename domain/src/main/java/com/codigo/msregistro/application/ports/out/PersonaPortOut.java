package com.codigo.msregistro.application.ports.out;

import com.codigo.msregistro.application.aggregate.dto.PersonaDto;

public interface PersonaPortOut {
    PersonaDto create_out(String dni);
    // buscar por dni
    PersonaDto findById_out(String dni);
    Boolean deleteById_out(String dni);
}
