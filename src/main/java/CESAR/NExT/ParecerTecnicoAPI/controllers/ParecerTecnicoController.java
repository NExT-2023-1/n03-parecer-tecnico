package CESAR.NExT.ParecerTecnicoAPI.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CESAR.NExT.ParecerTecnicoAPI.entities.ParecerTecnico;
import CESAR.NExT.ParecerTecnicoAPI.services.ExcelService;
import CESAR.NExT.ParecerTecnicoAPI.services.ParecerTecnicoService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pareceres")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParecerTecnicoController {
    
    private final ParecerTecnicoService parecerTecnicoService;
    
    @GetMapping("/excelFile")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=TodosPareceres" + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<ParecerTecnico> parecerTecnicoList = parecerTecnicoService.listAll();
        ExcelService service = new ExcelService(parecerTecnicoList);
        service.getAll(response);
    }
    
    @GetMapping("/{id}/excelFile")
    public void exportToExcel(HttpServletResponse response, @PathVariable long id) throws IOException {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ParecerTécnico" + ".xlsx";
        response.setHeader(headerKey, headerValue);

        ParecerTecnico parecerTecnico = parecerTecnicoService.getById(id);
        ExcelService service = new ExcelService(parecerTecnico);
        service.getFileById(response);
    }
}
