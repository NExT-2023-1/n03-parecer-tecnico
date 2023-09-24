package CESAR.NExT.ParecerTecnicoAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CESAR.NExT.ParecerTecnicoAPI.dto.ClienteDTO;
import CESAR.NExT.ParecerTecnicoAPI.entities.Cliente;
import CESAR.NExT.ParecerTecnicoAPI.services.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll() {
        List<Cliente> listClientes = this.clienteService.listAll();
        return new ResponseEntity<>(listClientes, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.create(clienteDTO);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable long id) {
        Cliente cliente = this.clienteService.getById(id);
        if (cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable long id, @RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.update(id, clienteDTO);
        if (cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (clienteService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
