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

import CESAR.NExT.ParecerTecnicoAPI.dto.EquipamentoDTO;
import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
import CESAR.NExT.ParecerTecnicoAPI.services.EquipamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/equipamento")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipamentoController {
    private final EquipamentoService equipamentoService;
    
    @GetMapping
    public ResponseEntity<List<Equipamento>> listAll() {
        List<Equipamento> listEquipamentos = this.equipamentoService.listAll();
        return new ResponseEntity<>(listEquipamentos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Equipamento> create(@RequestBody @Valid EquipamentoDTO equipamentoDTO) {
        Equipamento equipamento = equipamentoService.create(equipamentoDTO);
        return new ResponseEntity<>(equipamento, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> getById(@PathVariable long id) {
        Equipamento equipamento = this.equipamentoService.getById(id);
        if (equipamento != null){
            return new ResponseEntity<>(equipamento, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> update(@PathVariable long id, @RequestBody @Valid EquipamentoDTO equipamentoDTO) {
        Equipamento equipamento = equipamentoService.update(id, equipamentoDTO);
        if (equipamento != null){
            return new ResponseEntity<>(equipamento, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (equipamentoService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}