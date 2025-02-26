package Tournament;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
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

    public boolean addPlayer(Player player) {
        if (players.contains(player)) {
            return false;
        }
        players.add(player);
        player.setTeam(this);
        return true;
    }

    public boolean removePlayer(Player player) {
        if (!players.contains(player)) {
            return false;
        }
        players.remove(player);
        player.setTeam(null);
        return true;
    }
}
