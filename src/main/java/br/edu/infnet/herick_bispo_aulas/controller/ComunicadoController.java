package br.edu.infnet.herick_bispo_aulas.controller;

import br.edu.infnet.herick_bispo_aulas.domain.Comunicado;
import br.edu.infnet.herick_bispo_aulas.service.ComunicadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
