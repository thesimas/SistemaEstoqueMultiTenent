package br.edu.ifsc.fln.sistemaestoquemultitenent.repository;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    public List<Categoria> findByClienteId(Integer clienteId);
    public Optional<Categoria> findByIdAndClienteId(Integer id, Integer clienteId);
}

