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

            Caminhao caminhao = new Caminhao();
            caminhao.setPluviometros(Controle.contaPluviometro());
            caminhao.setTipo(tipo);
            lista.add(caminhao);
            int maior = 0;
            for (Caminhao caminhaoFrota : lista) {
                if (caminhaoFrota.getPluviometros() > maior) {
                    maior = caminhaoFrota.getPluviometros();
                    caminhaoTmp = caminhaoFrota;
                }
            }
        }
        if(caminhaoTmp != null && caminhaoTmp.getTipo() != null) {
            System.out.println("O tipo do caminhao mais rapido e " + caminhaoTmp.getTipo());
            System.out.println("A quantidade de pluviometros do caminhao mais rapido e: " + caminhaoTmp.getPluviometros());
        }
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
