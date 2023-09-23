package CESAR.NExT.ParecerTecnicoAPI.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CESAR.NExT.ParecerTecnicoAPI.dto.ClienteDTO;
import CESAR.NExT.ParecerTecnicoAPI.entities.Cliente;
import CESAR.NExT.ParecerTecnicoAPI.repositories.ClienteRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    public Cliente create(ClienteDTO clienteDTO) {
        Cliente cliente = clienteDTO.toEntity();
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> listAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().collect(Collectors.toList());
    }

    public Cliente getById(long id) {
        return this.clienteRepository.findById(id).orElse(null);
    }

    public Cliente update(long id, @Valid ClienteDTO clienteDTO) {
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        if(cliente != null) {
            Cliente updateCliente = clienteDTO.toEntityUpdate(cliente);
            return this.clienteRepository.save(updateCliente);
        }
        return null;
    }

    public boolean delete(long id) {
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        if (cliente != null){
            this.clienteRepository.delete(cliente);
            return true;
        }
        return false;
    }
}
