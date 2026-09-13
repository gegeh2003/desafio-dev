package br.com.soc.sistema.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.soc.sistema.vo.RelatorioCompromissoVo;


public class ExportadorExcel {
	
	public byte[] gerarExcel(List<RelatorioCompromissoVo> relatorio) {

        try {

            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Compromissos");

            Row cabecalho = sheet.createRow(0);

            cabecalho.createCell(0).setCellValue("Código Funcionário");
            cabecalho.createCell(1).setCellValue("Nome Funcionário");
            cabecalho.createCell(2).setCellValue("Código Agenda");
            cabecalho.createCell(3).setCellValue("Nome Agenda");
            cabecalho.createCell(4).setCellValue("Data do Compromisso");
            cabecalho.createCell(5).setCellValue("Hora do Compromisso");

            int linha = 1;

            for (RelatorioCompromissoVo compromisso : relatorio) {

                Row row = sheet.createRow(linha++);

                row.createCell(0).setCellValue(compromisso.getCodigoFuncionario());
                row.createCell(1).setCellValue(compromisso.getNomeFuncionario());
                row.createCell(2).setCellValue(compromisso.getCodigoAgenda());
                row.createCell(3).setCellValue(compromisso.getNomeAgenda());
                row.createCell(4).setCellValue(compromisso.getData());
                row.createCell(5).setCellValue(compromisso.getHorario());
            }

            for (int i = 0; i < 6; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            workbook.write(output);
            workbook.close();

            return output.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }
}
