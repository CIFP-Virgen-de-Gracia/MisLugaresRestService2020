package com.example.mislugaresrest.controller;


import com.example.mislugaresrest.dao.LugaresDAO;
import com.example.mislugaresrest.model.Lugar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController         // Definimos la clase como controlador REST
@RequestMapping("/")    // Definimos la url o entrada de la API REST, este caso la raíz: localhost:8080/
public class LugaresRESTController {

    // Inyección de dependecias para CRUD con LugaresDAO, JDataObject
    // https://www.baeldung.com/spring-dao-jpa
    @Autowired
    private LugaresDAO ld;

    /**
     * Metodo de test para
     * GET: http://localhost:8080/test
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String hola() {
        return "Mis Lugares REST OK!";
    }

    /********** CRUD ********/

    /**
     * Lista todos los Lugares. Protocolo GET
     * GET: http://localhost:8080/lugares
     *
     * @return Lista de lugares
     */
    @RequestMapping(value = "lugares", method = RequestMethod.GET)
    public ResponseEntity<List<Lugar>> findAll() {
        // Nos conectamos y realizamos el select
        List<Lugar> l = ld.findAll();
        // Devolvemos la ista de productos
        return ResponseEntity.ok(l);
    }
}
