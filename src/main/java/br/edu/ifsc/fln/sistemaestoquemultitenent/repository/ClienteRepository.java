package br.edu.ifsc.fln.sistemaestoquemultitenent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
