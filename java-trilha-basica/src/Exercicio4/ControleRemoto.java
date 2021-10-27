package Exercicio4;

public class ControleRemoto {
    private Televisao televisao;

    public ControleRemoto(Televisao televisao) {
        this.televisao = televisao;
    }

    public Televisao getTelevisao() {
        return televisao;
    }

    public void setTelevisao(Televisao televisao) {
        this.televisao = televisao;
    }

    public void ligaTelevisao() {
        getTelevisao().setLigada(true);
    }

    public void aumentaVolume() {
        if(getTelevisao().isLigada()) {
            getTelevisao().setVolume(getTelevisao().getVolume() + 1);
        }else {
            System.out.println("Favor ligar a televisao");
        }
    }
    public void diminuiVolume() {
        if(getTelevisao().isLigada()) {
            getTelevisao().setVolume(getTelevisao().getVolume() - 1);
        }else {
            System.out.println("Favor ligar a televisao");
        }
    }
    public void aumentaCanal() {
        if(getTelevisao().isLigada()) {
            getTelevisao().setCanal(getTelevisao().getCanal() + 1);
        }else {
            System.out.println("Favor ligar a televisao");
        }
    }
    public void diminuiCanal() {
        if(getTelevisao().isLigada() && getTelevisao().getVolume() > 0) {
            getTelevisao().setCanal(getTelevisao().getCanal() - 1);
        }else {
            System.out.println("Televisao desligada ou volume zero");
        }
    }
    public void consultaInformacao() {
        System.out.println("A tv esta liagada? " + getTelevisao().isLigada());
        System.out.println("O volume da tv é: " + getTelevisao().getVolume());
        System.out.println(("A tv esta no canal: " + getTelevisao().getCanal()));
    }
}
