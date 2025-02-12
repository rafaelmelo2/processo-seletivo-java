
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"João", "Maria", "José", "Ana", "Carlos"};
        for(String candidato : candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                System.out.println("Tentativa "+tentativasRealizadas+" de contato.");
                tentativasRealizadas++;
            }else{
                System.out.println("Candidato atendeu a ligação.");
            }
        }while(continuarTentando && tentativasRealizadas <3);
        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM O "+candidato+".");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O "+candidato+". NÚMERO MÁXIMO DE TENTATIVA REALIZADA: "+tentativasRealizadas);
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"João", "Maria", "José", "Ana", "Carlos"};
        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato ("+indice+") "+candidatos[indice]+" foi selecionado para a vaga.");
        }

        for (String candidato : candidatos) {
            System.out.println("O candidato "+candidato+" foi selecionado para a vaga.");
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }
    static void selecaoCandidatos(){
        String [] candidatos = {"João", "Maria", "José", "Ana", "Carlos"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato "+candidato+" solicitou este valor de salário: "+salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato "+candidato+" foi selecionado para a vaga.");
                candidatosSelecionados++;
            candidatosAtual++;
        }
        }
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }
        else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
        
    }

}
