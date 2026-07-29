package br.edu.infnet.herick_bispo_api;

import br.edu.infnet.herick_bispo_api.model.domain.Comunicado;
import br.edu.infnet.herick_bispo_api.model.domain.Escola;
import br.edu.infnet.herick_bispo_api.model.domain.Turma;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Loader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Escola escola = new Escola("Pombinho Feliz", "São Gonçalo", false, 4.8);

        Turma turma = new Turma("901", 2026, true);

        escola.adicionarTurma(turma);

        Comunicado comunicado001 = new Comunicado(
                "Reunião de Responsáveis",
                "A reunião será realizada na sexta feira.",
                true,
                LocalDateTime.now()
        );

        Comunicado comunicado002 = new Comunicado(
                "Trabalho de Java",
                "Entrega da primeira etapa na próxima semana.",
                false,
                null
        );

        turma.adicionarComunicado(comunicado001);
        turma.adicionarComunicado(comunicado002);

        System.out.println(escola);
        System.out.println(turma);

        turma.getComunicados().forEach(System.out::println);
    }
}
