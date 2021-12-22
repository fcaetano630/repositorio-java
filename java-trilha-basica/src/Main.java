import Exercicio1.Pessoa;
import Exercicio2.Agenda;
import Exercicio3.Elevador;
import Exercicio4.ControleRemoto;
import Exercicio4.Televisao;
import Exercicio5.Caminhao;
import Exercicio5.Controle;
import Exercicio5.Frota;
import Exercicio5.Tipo;

public class Main {
    public static void main(String[] args){
        /*Exercicio 1----------------------------------  TESTE*/
        Pessoa pessoa1 = new Pessoa("Felipe","26/10/1990",1.70);
        pessoa1.mostrarDados();
        pessoa1.calculaIdade();

        Pessoa pessoa2 = new Pessoa("Ana","12/10/2010",1.70);

        /*Exercicio 2---------------------------------- */
        Agenda agenda = new Agenda();
        agenda.armazenaPessoaLista(pessoa1);
        agenda.armazenaPessoaLista(pessoa2);

        agenda.removePessoaLista("Felipe");

        System.out.println(agenda.buscaPessoa("Ana"));

        agenda.imprimePessoa(0);

        agenda.imprimeAgenda();

        /*Exercicio 3---------------------------------- */

        Elevador elevador = new Elevador();
        elevador.inicializa(2,3);
        elevador.entra(pessoa1);

        System.out.println("Pessoas no elevador: " + elevador.getPessoasNoElevador());
        elevador.sobeAndar();
        elevador.sobeAndar();
        elevador.sobeAndar();
        elevador.desceAndar();
        elevador.desceAndar();
        elevador.desceAndar();
        System.out.println("Andar atual: " + elevador.getAndarAtual());

        /* Exercicio 4 ---------------------------------- */
        Televisao televisao = new Televisao();
        ControleRemoto controleRemoto = new ControleRemoto(televisao);
        controleRemoto.ligaTelevisao();
        controleRemoto.aumentaCanal();
        controleRemoto.consultaInformacao();
        controleRemoto.aumentaVolume();
        controleRemoto.consultaInformacao();

        /* Exercicio 5 ---------------------------------- */

        Frota.verificaCaminhoes();

    }
}
