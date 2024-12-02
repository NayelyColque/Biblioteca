package br.com.etechoracio.pw2_biblioteca.Controller;

import br.com.etechoracio.pw2_biblioteca.Entity.Livro;
import br.com.etechoracio.pw2_biblioteca.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.cadastrarLivro(livro));
    }
}

