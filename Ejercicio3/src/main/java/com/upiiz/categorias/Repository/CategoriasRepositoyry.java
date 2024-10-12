package com.upiiz.categorias.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.upiiz.categorias.Models.Categoria;

@Repository
public class CategoriasRepositoyry {
    // Almacenar las categorias
    // Genera de manera unica el id de cada categorias
    private List<Categoria> categorias = new ArrayList<Categoria>();
    private AtomicLong id = new AtomicLong();

    public Categoria guardar(Categoria categoria) {

        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    // GET - Todas las categorias
    public List<Categoria> obtenerTodas() {

        return categorias;
    }

    // GET solo un categoria
    public Categoria obtnerPorId(Long id) {

        /*
         * for (Categoria categoria : categorias) {
         * if (categoria.getId().equals(id)) {
         * return categoria;
         * }
         * }
         * return null;
         */
        // categorias.stream().filter(categoria ->
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);
    }

    // Delete
    public void eliminar(Long id) {
        categorias.removeIf(categoria -> categoria.getId().equals(id));

    }

    // PUT
    public Categoria actualizar(Categoria categoria) {
        eliminar(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }
}
