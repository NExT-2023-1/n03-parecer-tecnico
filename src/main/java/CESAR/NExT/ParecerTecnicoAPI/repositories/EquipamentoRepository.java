package CESAR.NExT.ParecerTecnicoAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{
    
}
