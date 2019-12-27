package com.example.mislugaresrest.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController         // Definimos la clase como controlador REST
@RequestMapping("/")    // Definimos la url o entrada de la API REST, este caso la raíz: localhost:8080/
public class LugaresRESTController {

    /**
     * Metodo de test para
     * GET: http://localhost:8080/test
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String hola() {
        return "Mis Lugares REST OK!";
    }
}
