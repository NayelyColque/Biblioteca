package br.com.etechoracio.pw2_biblioteca.Controller;

import br.com.etechoracio.pw2_biblioteca.Entity.Emprestimo;
import br.com.etechoracio.pw2_biblioteca.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<Emprestimo> registrarEmprestimo(@RequestBody Emprestimo emprestimo) {
        Emprestimo novoEmprestimo = emprestimoService.registrarEmprestimo(
                emprestimo.getLivro().getId(),
                emprestimo.getUsuario()
        );
        return ResponseEntity.ok(novoEmprestimo);
    }

    @GetMapping("/ativos/{usuario}")
    public ResponseEntity<List<Emprestimo>> listarEmprestimosAtivos(@PathVariable String usuario) {
        List<Emprestimo> emprestimosAtivos = emprestimoService.listarEmprestimosAtivos(usuario);
        return ResponseEntity.ok(emprestimosAtivos);
    }
}


