package com.example.mislugaresrest.dao;

import com.example.mislugaresrest.model.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Iimplementa todas las funciones de un CRUD de forma automática
 * JDataObject
 */
public interface LugaresDAO extends JpaRepository<Lugar, Long> {
}
