package br.com.etechoracio.pw2_biblioteca.Repository;

import br.com.etechoracio.pw2_biblioteca.Entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByUsuarioAndDataDevolucaoIsNull(String usuario);
}

