/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.prova1leandro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
    @Autowired
    private ClienteRepositorio clientes;
    
    @PostMapping("/novo")
    public Cliente salvar(@RequestBody Cliente cliente){
        return clientes.save(cliente);
    }
    
    @GetMapping
    public List<Cliente> pesquisar(){
        return clientes.findAll();
    }
    
    @PutMapping(value = "/altera/{id}")
    public Cliente altera(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente c = clientes.findOne(id);

        if (c.isPresent()) {
            Cliente c1 = c.get();
            c1.setId(cliente.getId());

            return clientes.save(c1);
        }else{
            return null;
        }
    }
}
