package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class SalvarEmArquivo {
    
    private static final String fileName = "D:\\Documentos\\Documentos do Usuário\\Acadêmico\\IFPB\\E.C\\Matérias\\Laboratório de POO\\Documentos\\Programas\\ProjectAvoe\\src\\Classes\\saves\\history.xls";
    
    public void save(Encomenda encomenda, Usuario logado) throws IOException {
        try {
            FileInputStream historyIn = new FileInputStream(new File(
                    SalvarEmArquivo.fileName));

            HSSFWorkbook planilha = new HSSFWorkbook(historyIn);
            HSSFSheet folha = planilha.getSheetAt(0);
            
            System.out.println("AQUIIII" + folha.getLastRowNum());
            
            Row linha = folha.createRow(folha.getLastRowNum() + 1);
            
            
            for (int x = 0; x < 9; x++) {
                Cell celula = linha.createCell(x);
                switch (x) {
                    //CONSERTAR
                    case 0:
                        celula.setCellValue(folha.getLastRowNum() - 1);
                        break;
                    case 1:
                        celula.setCellValue(encomenda.getCodigo());
                        break;
                    case 2:
                        celula.setCellValue(encomenda.getDestinatario().getProprietario());
                        break;
                    case 3:
                        celula.setCellValue(encomenda.getPeso());
                        break;
                    case 4:
                        if (encomenda.isCategoria()) {
                            celula.setCellValue("Carta");
                        }
                        else {
                            celula.setCellValue("Pacote");
                        }
                        break;
                    case 5:
                        celula.setCellValue(logado.getNome() + "(" + logado.getLogin() + ")");

                        break;
                    case 6:
                        //colocar data de cadastro da encomenda
                        break;
                    case 7:
                        //colocar hora de cadastro da encomenda
                        break;
                    case 8:
                        //colocar data de entrega da encomenda
                        break;
                    case 9:
                        //colocar hora de entrega da encomenda
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
