package com.codigo.msregistro.application.adapter;

import com.codigo.msregistro.application.aggregate.dto.PersonaDto;
import com.codigo.msregistro.application.client.ReniecClient;
import com.codigo.msregistro.application.client.ResponseReniec;
import com.codigo.msregistro.application.entity.PersonaEntity;
import com.codigo.msregistro.application.ports.out.PersonaPortOut;
import com.codigo.msregistro.application.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Service;

@Service
public class PersonaAdapter implements PersonaPortOut {
    @Autowired
    private ReniecClient reniecClient;
    @Value("$token.reniec")
    private String token;
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public PersonaDto create_out(String dni) {
        ResponseReniec responseReniec = reniecClient.getPersona(dni, token);
        PersonaEntity persona = new PersonaEntity();
        persona.setNumeroDocumento(responseReniec.getNumeroDocumento());
        persona.setNombres(responseReniec.getNombres());
        persona.setApellidoPaterno(responseReniec.getApellidoPaterno());
        persona.setApellidoMaterno(responseReniec.getApellidoMaterno());
        persona.setTipoDocumento(responseReniec.getTipoDocumento());
        persona.setEstado(true);
        PersonaEntity personaDb = personaRepository.save(persona);
        // mapear a personaDto
        PersonaDto personaDto = new PersonaDto();
        personaDto.setNombres(personaDb.getNombres());
        personaDto.setApellidoPaterno(personaDb.getApellidoPaterno());
        personaDto.setApellidoMaterno(personaDb.getApellidoMaterno());
        return personaDto;
    }

    @Override
    public PersonaDto findById_out(String dni) {
        return null;
    }

    @Override
    public Boolean deleteById_out(String dni) {
        return null;
    }
}
