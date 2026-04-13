package br.edu.ifsc.fln.sistemaestoquemultitenent.repository;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    public List<Produto> findByClienteId(Integer clienteId);
    public Optional<Produto> findByIdAndClienteId(Integer idProduto, Integer clienteId);
}