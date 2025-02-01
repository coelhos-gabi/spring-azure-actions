package cursos.br.com.example.controller;

import cursos.br.com.example.dto.CursoDTO;
import cursos.br.com.example.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarCursos(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> buscarPor(@PathVariable("id") int id){
        return new ResponseEntity<>(service.buscarPor(id), OK);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> cadastrar(@RequestBody CursoDTO cursoDTO){
        return new ResponseEntity<>(service.cadastrar(cursoDTO), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> atualizar(@PathVariable("id") int id,
                                              @RequestBody CursoDTO cursoDTO){
        return new ResponseEntity<>(service.atualizar(id, cursoDTO), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") int id){
        service.excluir(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
