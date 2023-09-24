package CESAR.NExT.ParecerTecnicoAPI.controllers;

import java.io.IOException;
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

import CESAR.NExT.ParecerTecnicoAPI.dto.ParecerTecnicoDTO;
import CESAR.NExT.ParecerTecnicoAPI.entities.ParecerTecnico;
import CESAR.NExT.ParecerTecnicoAPI.services.ExcelService;
import CESAR.NExT.ParecerTecnicoAPI.services.ParecerTecnicoService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/parecerTecnico")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParecerTecnicoController {
    private final ParecerTecnicoService parecerTecnicoService;
    
    @GetMapping
    public ResponseEntity<List<ParecerTecnico>> listAll() {
        List<ParecerTecnico> parecerList = this.parecerTecnicoService.listAll();
        return new ResponseEntity<>(parecerList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ParecerTecnico> create(@RequestBody @Valid ParecerTecnicoDTO parecerTecnicoDTO) {
        ParecerTecnico parecerTecnico = parecerTecnicoService.create(parecerTecnicoDTO);
        return new ResponseEntity<>(parecerTecnico, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ParecerTecnico> getById(@PathVariable long id) {
        ParecerTecnico parecerTecnico = this.parecerTecnicoService.getById(id);
        if (parecerTecnico != null){
            return new ResponseEntity<>(parecerTecnico, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ParecerTecnico> update(@PathVariable long id, @RequestBody @Valid ParecerTecnicoDTO parecerTecnicoDTO) {
        ParecerTecnico parecerTecnico = parecerTecnicoService.update(id, parecerTecnicoDTO);
        if (parecerTecnico != null){
            return new ResponseEntity<>(parecerTecnico, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (parecerTecnicoService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/excelFile")
    public void allFiles(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=listAllParecer" + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <ParecerTecnico> parecerList = parecerTecnicoService.listAll();
        ExcelService service = new ExcelService(parecerList);
        service.getAll(response);
    }
    
    @GetMapping("/{id}/excelFile")
    public void singleFile(HttpServletResponse response, @PathVariable long id) throws IOException {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=getByIdParecer" + ".xlsx";
        response.setHeader(headerKey, headerValue);

        ParecerTecnico parecerTecnico = parecerTecnicoService.getById(id);
        ExcelService service = new ExcelService(parecerTecnico);
        service.getFileById(response);
    }
}
