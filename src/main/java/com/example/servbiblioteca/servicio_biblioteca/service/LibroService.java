package com.example.servbiblioteca.servicio_biblioteca.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.servbiblioteca.servicio_biblioteca.model.Libro;
import com.example.servbiblioteca.servicio_biblioteca.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Optional<Libro> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro crear(Libro libro) {
        libro.setId(null);
        return libroRepository.save(libro);
    }

        public Optional<Libro> actualizar(Long id, Libro datos) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(datos.getTitulo());
            libro.setAutor(datos.getAutor());
            libro.setAnioPublicacion(datos.getAnioPublicacion());
            libro.setGenero(datos.getGenero());
            return libroRepository.save(libro);
        });
    }

    public boolean eliminar(Long id) {
        return libroRepository.findById(id).map(libro -> {
            libroRepository.delete(libro);
            return true;
        }).orElse(false);
    }

    
}