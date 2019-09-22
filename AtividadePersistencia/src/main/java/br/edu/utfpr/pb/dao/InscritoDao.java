/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.dao;

import br.edu.utfpr.pb.model.Inscrito;

/**
 *
 * @author macxi
 */
public class InscritoDao extends GenericDao<Inscrito, Long>{

    public InscritoDao() {
        super(Inscrito.class);
    }
    
}
