/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.prova1leandro;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 07610115959
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

    //public Cliente findOne(Long id);

}
