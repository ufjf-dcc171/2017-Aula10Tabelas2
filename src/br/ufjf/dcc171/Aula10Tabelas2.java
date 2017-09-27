package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Aula10Tabelas2 {

    public static void main(String[] args) {
        List<Pessoa> dados = getSampleData();
        JanelaTabela janela = new JanelaTabela(dados);
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    private static List<Pessoa> getSampleData() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>() {
            {
                add(new Pessoa("Fulano", 18, "fulano@gmail.com"));
                add(new Pessoa("Beltrano", 22, "beltrano@gmail.com"));
                add(new Pessoa("Ciclano", 15, "ciclano@gmail.com"));
            }
        };
        return pessoas;
    }

}
