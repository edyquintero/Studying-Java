package Tournament;

import java.util.List;

public class Team {
    String name;
    List<Player> players;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
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

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean addPlayer(Player player) {
        if (players.contains(player)) {
            return false;
        } else {
            players.add(player);
            return true;
        }
    }

    public boolean removePlayer(Player player) {
        if (players.contains(player)) {
            players.remove(player);
            return true;
        } else {
            return false;
        }
    }
}
