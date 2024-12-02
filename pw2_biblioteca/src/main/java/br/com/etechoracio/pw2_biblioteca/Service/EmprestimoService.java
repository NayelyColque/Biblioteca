package br.com.etechoracio.pw2_biblioteca.Service;

import br.com.etechoracio.pw2_biblioteca.Entity.Emprestimo;
import br.com.etechoracio.pw2_biblioteca.Entity.Livro;
import br.com.etechoracio.pw2_biblioteca.Repository.EmprestimoRepository;
import br.com.etechoracio.pw2_biblioteca.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    public Emprestimo registrarEmprestimo(Long livroId, String usuario) {

        Livro livro = livroRepository.findByIdAndDisponivelTrue(livroId).orElse(null);

        if (livro == null) {
            throw new RuntimeException("Livro indisponível");
        }

        List<Emprestimo> emprestimosAtivos = emprestimoRepository.findByUsuarioAndDataDevolucaoIsNull(usuario);
        if (emprestimosAtivos.size() >= 3) {
            throw new RuntimeException("Usuário já possui 3 empréstimos ativos");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(14));

        livro.setDisponivel(false);
        livroRepository.save(livro);

        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listarEmprestimosAtivos(String usuario){
        return emprestimoRepository.findByUsuarioAndDataDevolucaoIsNull(usuario);
    }
}

