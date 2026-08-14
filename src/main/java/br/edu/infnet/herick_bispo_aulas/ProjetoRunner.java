package br.edu.infnet.herick_bispo_aulas;

import br.edu.infnet.herick_bispo_aulas.domain.*;
import br.edu.infnet.herick_bispo_aulas.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ProjetoRunner implements CommandLineRunner {

    private final EscolaService escolaService;
    private final TurmaService turmaService;
    private final ComunicadoService comunicadoService;
    private final ProfessorService professorService;
    private final ResponsavelService responsavelService;

    private Escola escola;
    private Turma turma901;
    private Turma turma801;

    private Comunicado comunicado1;
    private Comunicado comunicado2;
    private Comunicado comunicado3;

    private Professor professor;
    private Responsavel responsavel;

    public ProjetoRunner(EscolaService escolaService,
                         TurmaService turmaService,
                         ComunicadoService comunicadoService,
                         ProfessorService professorService,
                         ResponsavelService responsavelService){

        this.escolaService = escolaService;
        this.turmaService = turmaService;
        this.comunicadoService = comunicadoService;
        this.professorService = professorService;
        this.responsavelService = responsavelService;
    }

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

        //Pessoas
        List<Pessoa> pessoas = List.of(professor,responsavel);
        pessoas.forEach(System.out::println);


        System.out.println("\n");

        //Escola
        System.out.println(escola);

        //Turma
        System.out.println(turma);

        //Comunicados
        comunicadoService.incluir(comunicado001);
        comunicadoService.incluir(comunicado002);
        comunicadoService.obterLista().forEach(System.out::println);
        comunicadoService.obterPublicados().forEach(System.out::println);
    }
}
