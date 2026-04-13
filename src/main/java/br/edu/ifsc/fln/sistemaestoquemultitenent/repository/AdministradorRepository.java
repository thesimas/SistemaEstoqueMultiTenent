package br.edu.ifsc.fln.sistemaestoquemultitenent.repository;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
}
