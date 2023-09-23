package CESAR.NExT.ParecerTecnicoAPI.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CESAR.NExT.ParecerTecnicoAPI.dto.ParecerTecnicoDTO;
import CESAR.NExT.ParecerTecnicoAPI.entities.Cliente;
import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
import CESAR.NExT.ParecerTecnicoAPI.entities.ParecerTecnico;
import CESAR.NExT.ParecerTecnicoAPI.repositories.ClienteRepository;
import CESAR.NExT.ParecerTecnicoAPI.repositories.EquipamentoRepository;
import CESAR.NExT.ParecerTecnicoAPI.repositories.ParecerTecnicoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParecerTecnicoService {
    
    private final ParecerTecnicoRepository parecerTecnicoRepository;
    private final ClienteRepository clienteRepository;
    private final EquipamentoRepository equipamentoRepository;

    public ParecerTecnico create(ParecerTecnicoDTO parecerTecnicoDTO) {
        
        Cliente cliente = this.clienteRepository.findById(parecerTecnicoDTO.getCliente_id()).orElse(null);
        Equipamento equipamento = this.equipamentoRepository.findById(parecerTecnicoDTO.getEquipamento_id()).orElse(null);

        if(cliente != null && equipamento != null) {
            ParecerTecnico parecerTecnico = parecerTecnicoDTO.toEntity(cliente, equipamento);
            return this.parecerTecnicoRepository.save(parecerTecnico);
        }
        return null;
    }

    public List<ParecerTecnico> listAll() {
        List<ParecerTecnico> parecerTecnicoList = parecerTecnicoRepository.findAll();
        return parecerTecnicoList.stream().collect(Collectors.toList());
    }

    public ParecerTecnico getById(long id) {
        return this.parecerTecnicoRepository.findById(id).orElse(null);
    }

    public ParecerTecnico update(long id, @Valid ParecerTecnicoDTO parecerTecnicoDTO) {
        
        ParecerTecnico parecerTecnico = this.parecerTecnicoRepository.findById(id).orElse(null);
        Cliente cliente = this.clienteRepository.findById(parecerTecnicoDTO.getCliente_id()).orElse(null);
        Equipamento equipamento = this.equipamentoRepository.findById(parecerTecnicoDTO.getEquipamento_id()).orElse(null);
        
        if (parecerTecnico != null && cliente != null && equipamento != null){
            
            parecerTecnico.setCliente(cliente);
            parecerTecnico.setEquipamento(equipamento);

            parecerTecnico = parecerTecnicoDTO.toEntityUpdate(parecerTecnico, cliente, equipamento);
            return this.parecerTecnicoRepository.save(parecerTecnico);
        }
        return null;
    }

    public boolean delete(long id) {
        ParecerTecnico parecerTecnico = this.parecerTecnicoRepository.findById(id).orElse(null);
        if (parecerTecnico != null){
            this.parecerTecnicoRepository.delete(parecerTecnico);
            return true;
        }
        return false;
    }
}