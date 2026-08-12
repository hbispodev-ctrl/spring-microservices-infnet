package br.edu.infnet.herick_bispo_aulas.service;

import br.edu.infnet.herick_bispo_aulas.domain.Comunicado;

import java.util.*;

public class ComunicadoService extends BaseService<Comunicado> {

    public List<Comunicado> obterPublicados(){

        List<Comunicado> publicados = new ArrayList<Comunicado>();
        obterLista();
        return publicados;
    }

    public List<Comunicado> obterListaPublicado(){
        return obterLista().stream().filter(Comunicado::isPublicado).toList();
    }

    public List<Comunicado> buscaPorTituloDeclarativa(String termo){

        obterLista().stream()
                .filter(comunicado -> comunicado
                        .getTitulo()
                        .toLowerCase()
                        .contains(termo.toLowerCase()))
                .toList();
        return null;
    }
}
