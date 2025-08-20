package forum.hub.challenger.controller;

import forum.hub.challenger.registro.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private RegistroRepository repository;

    @PostMapping
    @Transactional
    public void registrar(@RequestBody @Valid DadosRegistroTopicos dados) {
        repository.save(new Registro(dados));
    }

    @GetMapping
    public Page<DadosListarRegistro> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListarRegistro::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaTopicos dados){
        var registro = repository.getReferenceById(dados.id());
        registro.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
