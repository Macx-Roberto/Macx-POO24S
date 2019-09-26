/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.main;

import br.edu.utfpr.pb.dao.EventoDao;
import br.edu.utfpr.pb.dao.InscritoDao;
import br.edu.utfpr.pb.dao.PessoaDao;
import br.edu.utfpr.pb.model.Evento;
import br.edu.utfpr.pb.model.Pessoa;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.h2.tools.Server;

/**
 *
 * @author macxi
 */
public class NewMain {

    private static PessoaDao pessoaDao;
    private static InscritoDao inscritoDao;
    private static EventoDao eventoDao;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Server server = Server.createTcpServer("-tcpPort", "8082", "-tcpAllowOthers").start();
            new NewMain();
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.exit(0);
    }

    public NewMain() {
        System.out.println("Atividade Persistencia 2");
        inicializarDaos();
        
        inserirPessoas();
        inserirEventos();
        
    }
    
    

    private void inserirEventos() {
        Evento evt1 = new Evento();
        evt1.setNome("Baile funk filosofal");
        evt1.setDescricao("Lorem Ipsum é simplesmente" +
        " uma simulação de texto da indústria tipográfica " + 
        "e de impressos, e vem sendo utilizado desde o século XVI");
        evt1.setDataEvento(LocalDate.of(2019, Month.OCTOBER, 12));

        
        Evento evt2 = new Evento();
        evt2.setNome("Saindo da caverna");
        evt2.setDescricao("Lorem Ipsum é simplesmente" +
        " uma simulação de texto da indústria tipográfica " + 
        "e de impressos, e vem sendo utilizado desde o século XVI");
        evt2.setDataEvento(LocalDate.of(2019, Month.NOVEMBER, 10));

        Evento evt3 = new Evento();
        evt3.setNome("Batalha de rimas Platão X Aristóteles - A origem das ideias");
        evt3.setDescricao("Evento beneficiente para compra de pao e vinho");
        evt3.setDataEvento(LocalDate.of(2020, Month.APRIL, 1));
        
        eventoDao.insert(evt1);
        eventoDao.insert(evt2);
        eventoDao.insert(evt3);
    }

    private void inserirPessoas() {
        Pessoa pessoa_1 = new Pessoa();
        pessoa_1.setNome("Macx roberto");
        
        Pessoa pessoa_2 = new Pessoa();
        pessoa_2.setNome("Sigmund Freud");

        Pessoa pessoa_3 = new Pessoa();
        pessoa_3.setNome("Joana dark");

        Pessoa pessoa_4 = new Pessoa();
        pessoa_4.setNome("Friedrich Nietzsche");

        pessoaDao.insert(pessoa_1);
        pessoaDao.insert(pessoa_2);
        pessoaDao.insert(pessoa_3);
        pessoaDao.insert(pessoa_4);
    }

    private void inicializarDaos() {
        pessoaDao   = new PessoaDao();
        eventoDao   = new EventoDao();
        inscritoDao = new InscritoDao();
    }
    
}
