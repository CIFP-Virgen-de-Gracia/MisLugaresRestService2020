package com.example.mislugaresrest.controller;


import com.example.mislugaresrest.dao.LugaresDAO;
import com.example.mislugaresrest.model.Lugar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController         // Definimos la clase como controlador REST
@RequestMapping("/")    // Definimos la url o entrada de la API REST, este caso la raíz: localhost:8080/
public class LugaresRESTController {

    // Inyección de dependecias para CRUD con LugaresDAO, JDataObject
    // https://www.baeldung.com/spring-dao-jpa
    @Autowired
    private LugaresDAO ld;

    // Documentacion
    //http://localhost:8080/swagger-ui.html

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

    /**
     * Devuelve un lugar dado su ID protocolo GET
     * GET: http://localhost:8080/lugares/{id}
     *
     * @param id ID del lugar
     * @return Lugar
     */
    @RequestMapping(value = "lugares/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lugar> findById(@PathVariable("id") Long id) {
        // Buscamos el lugar por id
        Optional<Lugar> ol = ld.findById(id);
        // Devolvemos ellugar si existe.
        if (ol.isPresent()) {
            return ResponseEntity.ok(ol.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Crea un nuevo lugar. Protocolo POST
     * POST: http://localhost:8080/lugares
     * @param lugar Lugar a crear mendiante JSON
     * @return Lugar creado si lo consigue
     */
    @RequestMapping(value = "lugares", method = RequestMethod.POST)
    public ResponseEntity<Lugar> create(@RequestBody Lugar lugar) {
        // Creamos un nuevo lugar a partir de los datos una vez insertado
        Lugar l = ld.save(lugar);
        //devolvemos el nuevo producto
        return ResponseEntity.ok(l);
    }

    /**
     * Borra un lugar de la base de datos. Protocolo DELETE
     * DELETE: http://localhost:8080/lugares/{id}
     *
     * @param id, id del lugar a eliminar
     * @return
     */
    @RequestMapping(value = "lugares/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Lugar> delete(@PathVariable("id") Long id) {
        // Buscamos el lugar por id
        Optional<Lugar> ol = ld.findById(id);
        // si existe lo borramos y devolvemos
        if (ol.isPresent()) {
            // Le pasamos los datos
            Lugar p = ol.get();
            ld.deleteById(id);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Actualiza un lugar de la base de datos. Protocolo PUT
     * PUT: http://localhost:8080/lugares/{id}
     *
     * @param lugar Lugar a actualizar
     * @return Lugar actualizado
     */
    @RequestMapping(value = "lugares/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Lugar> update(@PathVariable("id") Long id, @RequestBody Lugar lugar) {
        // Buscamos el lugar por id
        Optional<Lugar> op = ld.findById(id);
        // Devolvemos el lugar si existe.
        if (op.isPresent()) {
            // Le pasamos los datos
            Lugar l = op.get();
            l.setNombre(lugar.getNombre());
            l.setTipo(lugar.getTipo());
            l.setFecha(lugar.getFecha());
            l.setLatitud(lugar.getLatitud());
            l.setLongitud(lugar.getLongitud());
            l.setImagen(lugar.getImagen());
            ld.save(l);
            return ResponseEntity.ok(l);
        } else {
            return ResponseEntity.noContent().build();
        }
    }



}
