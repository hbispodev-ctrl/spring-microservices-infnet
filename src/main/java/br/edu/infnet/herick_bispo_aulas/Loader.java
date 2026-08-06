package br.edu.infnet.herick_bispo_aulas;

import br.edu.infnet.herick_bispo_aulas.model.domain.*;
import br.edu.infnet.herick_bispo_aulas.model.service.ComunicadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@Component
public class Loader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Professor professor = new Professor(1L, "Joao","joao@gmail.com", "123", true);
        Responsavel responsavel = new Responsavel(2L, "Maria", "maria@gmail.com", "9999-9999", false);

        Escola escola = new Escola("Pombinho Feliz", "São Gonçalo", false, 4.8);
        Turma turma = new Turma("901", 2026, true);

        escola.adicionarTurma(turma);

        Comunicado comunicado001 = new Comunicado(
                1L,
                "Reunião de Responsáveis",
                "A reunião será realizada na sexta feira.",
                true,
                LocalDateTime.now()
        );

        Comunicado comunicado002 = new Comunicado(
                2L,
                "Trabalho de Java",
                "Entrega da primeira etapa na próxima semana.",
                false,
                null
        );

        turma.adicionarComunicado(comunicado001);
        turma.adicionarComunicado(comunicado002);

        List<Pessoa> pessoas = List.of(professor,responsavel);

        // Imprimir

        System.out.println("\n");
        pessoas.forEach(System.out::println);


        System.out.println("\n");
        System.out.println(escola);
        System.out.println(turma);

        System.out.println("\n");
        //turma.getComunicados().forEach(System.out::println);

        ComunicadoService comunicadoService = new ComunicadoService();
        comunicadoService.incluir(comunicado001);
        comunicadoService.incluir(comunicado002);
        comunicadoService.obterLista().forEach(System.out::println);

        System.out.println("\n");
        System.out.println(professor);
        System.out.println(responsavel);

    }
}
