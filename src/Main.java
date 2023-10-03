import Dao.CupDAO;
import Dao.MatchDAO;
import entities.WorldCup;
import entities.WorldCupMatches;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

public class Main {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {

        System.out.println("###### WORLD CUPS ######");

        int option = 0;

        do {
            System.out.println("Menu:");
            System.out.println("\n1. Listar todas as copas");
            System.out.println("\n2. Buscar copa");
            System.out.println("\n3. Alimentar dados da copa 2022");
            System.out.println("\n4. Buscar desempenho de uma seleção");
            System.out.println("\n5. Buscar copa 2.2");
            System.out.println("\n0. Finalizar");
            System.out.println("\nEscolha uma opção: ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println("Você selecionou uma opção incorreta! Selecione 1, 2, 3 ou 0 para finalizar.");
            }

                switch (option){
                    case 1:
                        ListaCopas();
                        break;
                    case 2:
                        BuscaCopa();
                        break;
                        case 3:InserirDados();
                        break;
                    case 4:
                        DesempenhoSelecao();
                        break;
                        case 5:
                        BuscaCopa2_2();
                        break;
                }

        }while (option !=0);
    }

    public static void ListaCopas(){
        CupDAO cup = new CupDAO();
        List<WorldCup> list =  cup.findAll();

        for (int i = 0; i < list.size(); i++) {
            System.out.println( list.get(i));
        }
    }

    public static void BuscaCopa(){
        CupDAO cup = new CupDAO();
        MatchDAO match = new MatchDAO();

        int option = 0;

        System.out.println("Informe o ano de busca desejado: ");
        try {
             option = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Parece que você pesquisou um ano inválido!");
        }

        if(option != 0){

        WorldCup data = cup.getById(option);

            System.out.println("\nPais sede: "+data.getCountry());
            System.out.println("Data da Final: "+data.getMatches().get(0).getDatetime());
            System.out.println("Estádio da Final: " + data.getMatches().get(0).getStadium());
            System.out.println("Times: "+ data.getMatches().get(0).getHomeTeamName() + " X " + data.getMatches().get(0).getAwayTeamName());
            System.out.println("Placar da final: "+data.getMatches().get(0).getHomeTeamGoals() +" - "+ data.getMatches().get(0).getAwayTeamGoals());
            System.out.println("Condições especiais de vitória: "+data.getMatches().get(0).getWinconditions());
        }
    }

    public static void BuscaCopa2_2(){
        CupDAO cup = new CupDAO();
        MatchDAO match = new MatchDAO();

        int option = 0;

        System.out.println("Informe o ano de busca desejado: ");
        try {
            option = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Parece que você pesquisou um ano inválido!");
        }

        if(option != 0){

            WorldCup data = cup.getById(option);

            System.out.println("\nPais sede: "+data.getCountry());
            System.out.println("Campeão: "+data.getWinner());
            System.out.println("Vice-campeão: "+data.getRunnersUp());
            System.out.println("Data da Final: "+data.getMatches().get(0).getDatetime());
            System.out.println("Estádio da Final: " + data.getMatches().get(0).getStadium());
            System.out.println("Placar da final: "+ data.getMatches().get(0).getHomeTeamInitials() +
                    " " + data.getMatches().get(0).getHomeTeamGoals() +" - "+
                    data.getMatches().get(0).getAwayTeamGoals()+ " "+
                    data.getMatches().get(0).getAwayTeamInitials());
        }
    }

    public static void InserirDados(){
        WorldCup cup = new WorldCup();

        cup.setYear(2022);
        cup.setCountry(RecebeEntrada("Pais sede: "));
        cup.setWinner(RecebeEntrada("Vencedor: "));
        cup.setRunnersUp(RecebeEntrada("Vice: "));
        cup.setThird(RecebeEntrada("Terceiro lugar: "));
        cup.setFourth(RecebeEntrada("Quarto Lugar: "));
        cup.setAttendance(RecebeEntrada("Público: "));
        cup.setGoalsScored(Integer.parseInt(RecebeEntrada("Gols marcados: ")));
        cup.setMatchesPlayed(Integer.parseInt(RecebeEntrada("Número de partidas: ")));
        cup.setQualifiedTeams(Integer.parseInt(RecebeEntrada("Número de equipes qualificadas: ")));

        CupDAO dao = new CupDAO();

        dao.InsertWorldCup(cup);

        InserirDadosFinal();
    }

    public static void InserirDadosFinal(){
        WorldCupMatches match = new WorldCupMatches();

        System.out.println("\nDados da Final\n");

        match.setYearCup(2022);
        match.setDatetime(RecebeEntrada("Data e horário: "));
        match.setStage("Final");
        match.setStadium(RecebeEntrada("Estádio: "));
        match.setCity(RecebeEntrada("Cidade: "));
        match.setHomeTeamName(RecebeEntrada("Time da casa: "));
        match.setHomeTeamInitials(RecebeEntrada("Iniciais: "));
        match.setHomeTeamGoals(Integer.parseInt(RecebeEntrada("Gols: ")));
        match.setAwayTeamName(RecebeEntrada("Time visitante: "));
        match.setAwayTeamInitials(RecebeEntrada("Iniciais: "));
        match.setAwayTeamGoals(Integer.parseInt(RecebeEntrada("Gols: ")));
        match.setWinconditions(RecebeEntrada("Condições de vitória: "));
        match.setReferee(RecebeEntrada("Arbitro: "));
        match.setMatchID(Integer.parseInt(RecebeEntrada("Id da partida: ")));

        MatchDAO dao = new MatchDAO();

        dao.InsertWorldCupMatch(match);

    }

    public static void DesempenhoSelecao(){
        CupDAO cup = new CupDAO();
        String selecao = RecebeEntrada("Informe a seleção (Inglês): ");
        List<WorldCup> list =  cup.Desempenho(selecao);

        int primeiro = 0;
        int segundo = 0;
        int terceiro = 0;
        int quarto = 0;

        for (int i = 0; i < list.size(); i++) {
            System.out.println("\n");
            System.out.println("Ano: " +list.get(i).getYear());
            System.out.println("País sede: " +list.get(i).getCountry());

            if(list.get(i).getWinner().equals( selecao)){
                System.out.println("Colocação: Vencedor");
                primeiro++;
            } else if (list.get(i).getRunnersUp().equals(selecao)) {
                System.out.println("Colocação: Vice-campeão");
                segundo++;
            } else if (list.get(i).getThird().equals(selecao)) {
                System.out.println("Colocação: Terceiro Lugar");
                terceiro++;
            }else{
                System.out.println("Colocação: Quarto Lugar");
                quarto++;
            }
        }

        System.out.println("\n1º "+primeiro+" vezes");
        System.out.println("2º "+segundo+" vezes");
        System.out.println("3º "+terceiro+" vezes");
        System.out.println("4º "+quarto+" vezes");
    }

    public static String RecebeEntrada(String text){
        String entrada ="";

        System.out.println(text);
        try {
            entrada= br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entrada;
    }

}