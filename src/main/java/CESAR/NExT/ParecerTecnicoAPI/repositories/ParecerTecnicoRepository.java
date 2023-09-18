package CESAR.NExT.ParecerTecnicoAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CESAR.NExT.ParecerTecnicoAPI.entities.ParecerTecnico;

@Repository
public interface ParecerTecnicoRepository extends JpaRepository<ParecerTecnico, Long> {
    
}