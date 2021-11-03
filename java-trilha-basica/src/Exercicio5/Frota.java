package Exercicio5;

import java.util.ArrayList;
import java.util.List;

public class Frota extends Controle {

    private static List<Caminhao> lista ;

    public List<Caminhao> getLista() {
        return lista;
    }

    public void setLista(List<Caminhao> lista) {
        this.lista = lista;
    }

    public static void verificaCaminhoes() {
        Caminhao caminhaoTmp = new Caminhao();
        Tipo tipo;
        boolean continuaPrograma = true;
        lista = new ArrayList<>();

        while(continuaPrograma) {
            String entrada = Controle.falaTipoCaminhao();
            tipo = verificaTipo(entrada);
            if(tipo.equals(Tipo.ENCERRAR)) {
                System.out.println("Voce encerrou o programa ");
                break;
            }
            if ((tipo.equals(Tipo.REPETIR))) {
                verificaCaminhoes();
            }
            adicionaCaminhao(tipo);
            int maior = 0;
            for (Caminhao caminhaoFrota : lista) {
                    if (caminhaoFrota.somaCapacidadePluviometro(caminhaoFrota.getListaPluviometros()) > maior) {
                        maior = caminhaoFrota.somaCapacidadePluviometro(caminhaoFrota.getListaPluviometros());
                        caminhaoTmp = caminhaoFrota;
                    }
            }
        }
        if(caminhaoTmp != null && caminhaoTmp.getTipo() != null) {
            System.out.println("O tipo do caminhao mais rapido e " + caminhaoTmp.getTipo());
            System.out.println("O caminhao mais rapido tem : " +
                                caminhaoTmp.somaCapacidadePluviometro(caminhaoTmp.getListaPluviometros()) + " ml de capacidade ");
        }
    }

    private static void adicionaCaminhao(Tipo tipo) {
        Caminhao caminhao = new Caminhao();
        caminhao.setPluviometros(Controle.contaPluviometro());
        for(int i = 0; i < caminhao.getPluviometros(); i++) {
            caminhao.criaPluviometro();
        }
        caminhao.setTipo(tipo);
        lista.add(caminhao);
    }

    public static Tipo verificaTipo(String entrada) {
        if(entrada.equalsIgnoreCase("Alfa")) {
            return Tipo.ALFA;
        }
        if(entrada.equalsIgnoreCase("Beta")) {
            return Tipo.BETA;
        }
        if(entrada.equalsIgnoreCase("fim")) {
            return Tipo.ENCERRAR;
        }
        return Tipo.REPETIR;
    }
}
