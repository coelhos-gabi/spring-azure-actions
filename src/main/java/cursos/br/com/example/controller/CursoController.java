package cursos.br.com.example.controller;

import cursos.br.com.example.dto.CursoDTO;
import cursos.br.com.example.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name= "Cursos")
public class CursoController {

    private CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String getHealth(){
        return "Cursos::UP";
    }

    @GetMapping
    @Operation(summary = "Listagem de cursos")
    public ResponseEntity<List<CursoDTO>> listarCursos(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca por um curso")
    public ResponseEntity<CursoDTO> buscarPor(@PathVariable("id") int id){
        return new ResponseEntity<>(service.buscarPor(id), OK);
    }

    @PostMapping
    @Operation(summary = "Cadastra um curso")
    public ResponseEntity<CursoDTO> cadastrar(@RequestBody CursoDTO cursoDTO){
        return new ResponseEntity<>(service.cadastrar(cursoDTO), CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atuliza informações do curso")
    public ResponseEntity<CursoDTO> atualizar(@PathVariable("id") int id,
                                              @RequestBody CursoDTO cursoDTO){
        return new ResponseEntity<>(service.atualizar(id, cursoDTO), OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um curso")
    public ResponseEntity<Void> excluir(@PathVariable("id") int id){
        service.excluir(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
