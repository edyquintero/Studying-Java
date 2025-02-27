package Tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tournament {
    private String name;
    private List<Player> players;
    private List<String> historyClashes;

    public Tournament(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.historyClashes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getHistoryClashes() {
        return historyClashes;
    }

    public boolean addPlayer(Player player) {
        if (players.contains(player)) {
            return false;
        }
        players.add(player);
        return true;
    }

    public Player confront(Player player1, Player player2) {
        if (!players.contains(player1) || !players.contains(player2)) {
            return null;
        }
        if (player1.getAbilityPower() > player2.getAbilityPower()) {
            return player1;
        } else if (player2.getAbilityPower() > player1.getAbilityPower()) {
            return player2;
        } else {
            return new Random().nextBoolean() ? player1 : player2; // Empate, elige al azar
        }
    }

    public boolean startTournament() {
        if (players.size() < 2) {
            return false;
        }
        Random rand = new Random();
        while (players.size() > 1) {
            Player p1 = players.get(rand.nextInt(players.size()));
            Player p2 = players.get(rand.nextInt(players.size()));
            while (p1 == p2) {
                p2 = players.get(rand.nextInt(players.size()));
            }
            Player winner = confront(p1, p2);
            if (winner != null) {
                System.out.println(p1.getName() + " vs " + p2.getName() + " -> Gana: " + winner.getName());
                historyClashes.add(p1.getName() + " vs " + p2.getName() + " -> Gana: " + winner.getName());
                winner.winGame();
                if (winner != p1) {
                    p1.loseGame();
                } else {
                    p2.loseGame();
                }
                players.remove(p1 == winner ? p2 : p1);
            }
        }
        return true;
    }

    public void showHistory() {
        historyClashes.forEach(System.out::println);
    }
}
