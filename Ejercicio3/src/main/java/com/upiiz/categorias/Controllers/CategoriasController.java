package com.upiiz.categorias.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.categorias.Models.Categoria;
import com.upiiz.categorias.Services.CategoriasService;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {
    @Autowired
    private CategoriasService categoriasService;

    @GetMapping()
    public ResponseEntity<List<Categoria>> getCategorias() {
        return ResponseEntity.ok(categoriasService.getAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(categoriasService.getCategoriaById(id));
    }

    @PostMapping()
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriasService.createCategoria(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
        categoria.setId(id);
        return ResponseEntity.ok(categoriasService.updateCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoriasService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
