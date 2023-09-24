package CESAR.NExT.ParecerTecnicoAPI.services;

import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import CESAR.NExT.ParecerTecnicoAPI.entities.ParecerTecnico;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelService {
    private ParecerTecnico parecerTecnico;
    private List <ParecerTecnico> parecerTecnicoList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelService(ParecerTecnico parecerTecnico) {
        this.parecerTecnico = parecerTecnico;
        workbook = new XSSFWorkbook();
    }

    public ExcelService(List <ParecerTecnico> parecerTecnicoList) {
        this.parecerTecnicoList = parecerTecnicoList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeader() {
        sheet = workbook.createSheet("Parecer Técnico");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "Nome do Cliente", style);
        createCell(row, 2, "Tipo do Equipamento", style);
        createCell(row, 3, "Defeito", style);
        createCell(row, 4, "Parecer", style);
    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }

    private void writeOne() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        if (parecerTecnico != null) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, parecerTecnico.getId(), style);
            createCell(row, columnCount++, parecerTecnico.getCliente().getNome(), style);
            createCell(row, columnCount++, parecerTecnico.getEquipamento().getTipo(), style);
            createCell(row, columnCount++, parecerTecnico.getDefeito(), style);
            createCell(row, columnCount++, parecerTecnico.getParecer(), style);
        }
    }
    
    private void writeAll() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (ParecerTecnico record: parecerTecnicoList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getId(), style);
            createCell(row, columnCount++, record.getCliente().getNome(), style);
            createCell(row, columnCount++, record.getEquipamento().getTipo(), style);
            createCell(row, columnCount++, record.getDefeito(), style);
            createCell(row, columnCount++, record.getParecer(), style);
        }
    }  

    public void getFileById(HttpServletResponse response) throws IOException {
        writeHeader();
        writeOne();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public void getAll(HttpServletResponse response) throws IOException {
        writeHeader();
        writeAll();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
