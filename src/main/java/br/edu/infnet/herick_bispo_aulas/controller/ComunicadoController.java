package br.edu.infnet.herick_bispo_aulas.controller;

import br.edu.infnet.herick_bispo_aulas.domain.Comunicado;
import br.edu.infnet.herick_bispo_aulas.service.ComunicadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comunicados")
public class ComunicadoController {

    private final ComunicadoService comunicadoService;

    public ComunicadoController(ComunicadoService comunicadoService){
        this.comunicadoService = comunicadoService;
    }


    @GetMapping
    public ResponseEntity<List<Comunicado>> obterLista(){

        List<Comunicado> comunicados = comunicadoService.obterLista();

        return ResponseEntity.ok(comunicados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comunicado>  obertPorId(@PathVariable Long id){

        Comunicado comunicado = comunicadoService.obertPorId(id);

        return ResponseEntity.ok(comunicado);
    }

    @GetMapping(params = "titulo")
    public ResponseEntity<List<Comunicado>>  obertPorTitulo(@RequestParam String titulo){

        List<Comunicado> comunicados = comunicadoService.obterPorTitulo(titulo);
        return ResponseEntity.ok(comunicados);
    }

    @PostMapping
    public ResponseEntity<Comunicado> incluir(@RequestBody Comunicado comunicado){

        comunicadoService.incluir(comunicado);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(comunicado.getId()).toUri();

        return  ResponseEntity.created(location).body(comunicado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comunicado> alterar(@PathVariable Long id, @RequestBody Comunicado comunicado){

        comunicado.setId(id);

        comunicadoService.alterar(comunicado);

        return ResponseEntity.ok(comunicado);
    }

}
