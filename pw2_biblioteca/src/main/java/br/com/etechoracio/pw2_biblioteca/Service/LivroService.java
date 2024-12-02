package br.com.etechoracio.pw2_biblioteca.Service;

import br.com.etechoracio.pw2_biblioteca.Entity.Livro;
import br.com.etechoracio.pw2_biblioteca.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro cadastrarLivro(Livro livro) {
        return livroRepository.save(livro);
    }
}

