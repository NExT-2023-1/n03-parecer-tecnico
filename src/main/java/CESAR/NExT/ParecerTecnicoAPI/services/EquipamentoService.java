package CESAR.NExT.ParecerTecnicoAPI.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import CESAR.NExT.ParecerTecnicoAPI.dto.EquipamentoDTO;
import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
import CESAR.NExT.ParecerTecnicoAPI.repositories.EquipamentoRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public Equipamento create(EquipamentoDTO equipamentoDTO) {
        Equipamento equipamento = equipamentoDTO.toEntity();
        return this.equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listAll() {
        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        return equipamentos.stream().collect(Collectors.toList());
    }

    public Equipamento getById(long id) {
        return this.equipamentoRepository.findById(id).orElse(null);
    }

    public Equipamento update(long id, @Valid EquipamentoDTO equipamentoDTO) {
        Equipamento equipamento = this.equipamentoRepository.findById(id).orElse(null);
        if (equipamento != null){
            Equipamento updateEquipamento = equipamentoDTO.toEntityUpdate(equipamento);
            return this.equipamentoRepository.save(updateEquipamento);
        }
        return null;
    }

    public boolean delete(long id) {
        Equipamento equipamento = this.equipamentoRepository.findById(id).orElse(null);
        if (equipamento != null){
            this.equipamentoRepository.delete(equipamento);
            return true;
        }
        return false;
    } 
}