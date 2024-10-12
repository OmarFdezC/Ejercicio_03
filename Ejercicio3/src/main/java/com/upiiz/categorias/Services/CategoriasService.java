package com.upiiz.categorias.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.upiiz.categorias.Models.Categoria;
import com.upiiz.categorias.Repository.CategoriasRepositoyry;

@Service
public class CategoriasService {
    CategoriasRepositoyry categoriasRepositoyry;

    public CategoriasService(CategoriasRepositoyry categoriasRepositoyry) {
        this.categoriasRepositoyry = categoriasRepositoyry;
    }

    // @GetMapping()
    public List<Categoria> getAllCategorias() {
        return categoriasRepositoyry.obtenerTodas();
    }

    // @GetMapping("/{id}")
    public Categoria getCategoriaById(Long id) {
        return categoriasRepositoyry.obtnerPorId(id);
    }

    // @PostMapping()
    public Categoria createCategoria(Categoria categoria) {
        return categoriasRepositoyry.guardar(categoria);
    }

    // @PutMapping("/{id}")
    public Categoria updateCategoria(Categoria categoria) {
        return categoriasRepositoyry.actualizar(categoria);
    }

    // DeleteMapping("/{id}")
    public void deleteCategoria(Long id) {
        categoriasRepositoyry.eliminar(id);
    }

}
