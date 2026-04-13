package br.edu.ifsc.fln.sistemaestoquemultitenent.repository;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    public List<Fornecedor> findByClienteId(Integer clienteId);
    Optional<Fornecedor> findByIdAndClienteId(Integer id, Integer clienteId);
}

