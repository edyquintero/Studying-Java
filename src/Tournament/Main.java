package Tournament;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TournamentManager manager = new TournamentManager();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Tournament Manager ---");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Agregar equipo");
            System.out.println("3. Agregar torneo");
            System.out.println("4. Asignar jugador a equipo");
            System.out.println("5. Agregar jugador a torneo");
            System.out.println("6. Iniciar torneo");
            System.out.println("7. Mostrar historial de torneos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del jugador: ");
                    String playerName = scanner.nextLine();
                    System.out.print("Ingrese el poder de habilidad del jugador: ");
                    int abilityPower = scanner.nextInt();
                    manager.addPlayer(playerName, abilityPower);
                    System.out.println("Jugador agregado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del equipo: ");
                    String teamName = scanner.nextLine();
                    if (manager.addTeam(teamName)) {
                        System.out.println("Equipo agregado con éxito.");
                    } else {
                        System.out.println("El equipo ya existe.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del torneo: ");
                    String tournamentName = scanner.nextLine();
                    if (manager.addTournament(tournamentName)) {
                        System.out.println("Torneo agregado con éxito.");
                    } else {
                        System.out.println("El torneo ya existe.");
                    }
                    break;

                case 4:
                    System.out.println("Seleccione el jugador a agregar a un equipo:");
                    for (int i = 0; i < manager.getPlayers().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getPlayers().get(i).getName());
                    }
                    int playerIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir salto de línea

                    System.out.println("Seleccione el equipo:");
                    for (int i = 0; i < manager.getTeams().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getTeams().get(i).getName());
                    }
                    int teamIndex = scanner.nextInt() - 1;

                    if (playerIndex >= 0 && playerIndex < manager.getPlayers().size() &&
                            teamIndex >= 0 && teamIndex < manager.getTeams().size()) {
                        manager.addPlayerToTeam(manager.getPlayers().get(playerIndex), manager.getTeams().get(teamIndex));
                        System.out.println("Jugador agregado al equipo con éxito.");
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;

                case 5:
                    System.out.println("Seleccione el torneo:");
                    for (int i = 0; i < manager.getTournaments().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getTournaments().get(i).getName());
                    }
                    int tournamentIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir salto de línea

                    System.out.println("Seleccione el jugador:");
                    for (int i = 0; i < manager.getPlayers().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getPlayers().get(i).getName());
                    }
                    int selectedPlayerIndex = scanner.nextInt() - 1;

                    if (tournamentIndex >= 0 && tournamentIndex < manager.getTournaments().size() &&
                            selectedPlayerIndex >= 0 && selectedPlayerIndex < manager.getPlayers().size()) {
                        manager.getTournaments().get(tournamentIndex).addPlayer(manager.getPlayers().get(selectedPlayerIndex));
                        System.out.println("Jugador agregado al torneo con éxito.");
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;

                case 6:
                    System.out.println("Seleccione el torneo a iniciar:");
                    for (int i = 0; i < manager.getTournaments().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getTournaments().get(i).getName());
                    }
                    int startTournamentIndex = scanner.nextInt() - 1;

                    if (startTournamentIndex >= 0 && startTournamentIndex < manager.getTournaments().size()) {
                        if (manager.getTournaments().get(startTournamentIndex).startTournament()) {
                            System.out.println("¡Torneo iniciado con éxito!");
                        } else {
                            System.out.println("No hay suficientes jugadores para iniciar el torneo.");
                        }
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;

                case 7:
                    System.out.println("Seleccione el torneo para ver el historial:");
                    for (int i = 0; i < manager.getTournaments().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getTournaments().get(i).getName());
                    }
                    int historyTournamentIndex = scanner.nextInt() - 1;

                    if (historyTournamentIndex >= 0 && historyTournamentIndex < manager.getTournaments().size()) {
                        System.out.println("Historial de enfrentamientos:");
                        manager.getTournaments().get(historyTournamentIndex).showHistory();
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 8);

        scanner.close();
    }
}
