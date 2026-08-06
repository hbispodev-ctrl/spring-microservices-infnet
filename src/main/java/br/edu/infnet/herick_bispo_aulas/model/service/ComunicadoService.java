package br.edu.infnet.herick_bispo_aulas.model.service;

import br.edu.infnet.herick_bispo_aulas.model.domain.Comunicado;

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
}
