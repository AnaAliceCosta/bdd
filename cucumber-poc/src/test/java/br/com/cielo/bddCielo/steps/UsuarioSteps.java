package br.com.cielo.bddCielo.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class UsuarioSteps {

    @Dado("um usuário não cadastrado")
    public void um_usuário_não_cadastrado() {
        System.out.println();
    }

    @Quando("realizo o cadastramento do usuário")
    public void realizo_o_cadastramento_do_usuário() {
        System.out.println();
    }

    @Então("o usuário é registrado com sucesso")
    public void o_usuário_é_registrado_com_sucesso() {
        System.out.println();
    }
}
