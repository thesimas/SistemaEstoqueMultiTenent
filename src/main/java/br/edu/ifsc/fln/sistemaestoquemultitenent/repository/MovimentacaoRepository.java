package br.edu.ifsc.fln.sistemaestoquemultitenent.repository;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    public List<Movimentacao> findByClienteId(Integer clienteId);
    public Optional<Movimentacao> findByIdAndClienteId(Integer idMovimentacao, Integer clienteId);
}

