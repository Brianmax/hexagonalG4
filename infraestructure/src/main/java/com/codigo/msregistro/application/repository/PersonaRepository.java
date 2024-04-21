package com.codigo.msregistro.application.repository;

import com.codigo.msregistro.application.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, String> {
    PersonaEntity findByApellidoPaternoAndApellidoMaterno(String apellidoPaterno, String apellidoMaterno);

}
