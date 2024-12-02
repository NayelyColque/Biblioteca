package br.com.etechoracio.pw2_biblioteca.Repository;

import br.com.etechoracio.pw2_biblioteca.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Override
    Optional<Livro> findById(Long aLong);

    Optional<Livro> findByIdAndDisponivelTrue(Long id);
}
