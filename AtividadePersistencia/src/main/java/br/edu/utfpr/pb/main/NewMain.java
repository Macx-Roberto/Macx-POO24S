/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.main;

import br.edu.utfpr.pb.model.Evento;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.h2.tools.Server;

/**
 *
 * @author macxi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Server server = Server.createTcpServer("-tcpPort", "8082", "-tcpAllowOthers").start();
                
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Evento evtMacx = new Evento();
        evtMacx.setDescricao("zecatatuamarelobrancopreto teste de insert");
        evtMacx.setNome("Evento do macx");
        //evtMacx.setDataEvento(LocalDate.MIN);
        
        System.exit(0);
    }
    
}
