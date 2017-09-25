package Classes;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class SalvarEmArquivo implements Serializable {
    
    private static final String fileName = "C:\\Users\\guisi\\OneDrive\\Documentos\\Engenharia de Computação\\Programação Orientada a Objetos\\ProjectAvoe\\src\\Classes\\saves\\history.xls";
    
    public static String createDate(){
            java.util.Date data = new Date();
            String nomedata = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
            
            return(nomedata);
        }
    
    public static String createHour(){
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat("HH:mm:ss");
        String hora = formata.format(agora);
        
        return(hora);
    }
    
    public void save(Encomenda encomenda, Usuario logado) throws IOException {
        try {
            FileInputStream historyIn = new FileInputStream(new File(
                    SalvarEmArquivo.fileName));

            HSSFWorkbook planilha = new HSSFWorkbook(historyIn);
            HSSFSheet folha = planilha.getSheetAt(0);
            
            System.out.println(folha.getLastRowNum());
            Row linha = folha.createRow(folha.getLastRowNum() + 1);
            
            
            for (int x = 0; x <= 9; x++) {
                Cell celula = linha.createCell(x);
                switch (x) {
                    //CONSERTAR
                    case 0:
                        celula.setCellValue(folha.getLastRowNum() - 1);
                        break;
                    case 1:
                        celula.setCellValue(encomenda.getData());
                        break;
                    case 2:
                        celula.setCellValue(encomenda.getHora());
                        break;
                    case 3:
                        celula.setCellValue(encomenda.getCodigo());
                        break;
                    case 4:
                        celula.setCellValue(encomenda.getDestinatario().getProprietario());
                        break;
                    case 5:
                        celula.setCellValue(encomenda.getPeso());
                        break;
                    case 6:
                        if (encomenda.isCategoria()) {
                            celula.setCellValue("Carta");
                        }
                        else {
                            celula.setCellValue("Pacote");
                        }
                        break;
                    case 7:
                        celula.setCellValue(logado.getNome() + "(" + logado.getLogin() + ")");
                        break;
                    case 8:
                        celula.setCellValue(createDate());
                        break;
                    case 9:
                        celula.setCellValue(createHour());
                        break;
                }
            }

            historyIn.close();

            FileOutputStream historyOut = new FileOutputStream(new File(SalvarEmArquivo.fileName));
            planilha.write(historyOut);
            historyOut.close();
            
        } catch (FileNotFoundException a) {
            a.printStackTrace();
        } catch (IOException b) {
            b.printStackTrace();
        }
    }
}
