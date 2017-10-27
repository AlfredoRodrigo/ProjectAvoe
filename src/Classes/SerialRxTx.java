/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 * Classe de comunicação bidirecional entre computador e Arduino
 * @author alf_r - extraído do professor André Curvello: https://www.youtube.com/channel/UCH-yNyoZficULIjce_2OzvA
 */
public class SerialRxTx implements SerialPortEventListener {

    SerialPort serialPort = null;
    
    private Protocolo protocolo = new Protocolo(); //objeto de gestão de protocolo
    private String appName; //nome da aplicação
    
    private BufferedReader input; //objeto para leitura na serial
    private OutputStream output; //objeto para escrita na serial
    
    private static final int TIME_OUT = 1000; //referência para tempo de espera para comunicação serial
    private static int DATA_RATE = 9600; //velocidade da comunicação serial
    
    private String serialPortName = "COM3"; //nome da porta
    
    public boolean iniciaSerial() { //ler dados do Arduino
        boolean status = false; //será o retorno da função
        try {
            //obtem portas seriais do sistema
            CommPortIdentifier portId = null; //identificador de porta serial
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers(); //enumerador (recebe em ordem as portas seriais cadastradas no SO)
            
            while (portId == null && portEnum.hasMoreElements()) {
                //varre as portas para encontrar a desejada
                CommPortIdentifier currentPortId = (CommPortIdentifier) portEnum.nextElement();
                
                if (currentPortId .getName().equals(serialPortName) || currentPortId.getName().startsWith(serialPortName)) {
                    serialPort = (SerialPort) currentPortId.open(appName, TIME_OUT);
                    portId = currentPortId;
                    System.out.println("Conectado em: " + currentPortId.getName());
                    break;
                }
            }
            
            if (portId == null || serialPort == null) {
                return false;
            }
            
            serialPort.setSerialPortParams(DATA_RATE, //velocidade de porta serial
                    SerialPort.DATABITS_8, //tamanho da palavra passada pela porta serial
                    SerialPort.STOPBITS_1, //um bit de parada
                    SerialPort.PARITY_NONE); //sem paridade
            
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            status = true;
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        
        return status;
        
    }
    
    public void sendData(String data) { //enviar dados pela serial para o Arduino
        try {
            output = serialPort.getOutputStream();
            output.write(data.getBytes());
        } catch (Exception e) {
            System.err.println(e.toString());
            //podemos até exibir uma mensagem aqui!
        }
    }
    
    public synchronized void close() { //fecha a porta serial
        if (serialPort != null) {
            serialPort.removeEventListener(); //remove métodos cadastrados como Listeners
            serialPort.close(); //libera a porta serial para o SO
        }
    }
    
    @Override
    public void serialEvent(SerialPortEvent spe) {
        //lida com a chegada de dados pela serial ao computador
        try {
            switch(spe.getEventType()) {
                case SerialPortEvent.DATA_AVAILABLE:
                    if (input == null) {
                        input = new BufferedReader(
                                new InputStreamReader(
                                        serialPort.getInputStream()));
                    }
                    
                    if (input.ready()) {
                        protocolo.setLeituraComando(input.readLine());
                        System.out.println("Chegou: " + protocolo.getLeituraComando());
                    }
                    
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    public static int getDATA_RATE() {
        return DATA_RATE;
    }

    public static void setDATA_RATE(int DATA_RATE) {
        SerialRxTx.DATA_RATE = DATA_RATE;
    }

    public String getSerialPortName() {
        return serialPortName;
    }

    public void setSerialPortName(String serialPortName) {
        this.serialPortName = serialPortName;
    }
}
