package Tournament;

import java.util.ArrayList;
import java.util.List;

public class TournamentManager {
    private List<Tournament> tournaments;
    private List<Player> players;
    private List<Team> teams;

    public TournamentManager() {
        this.tournaments = new ArrayList<>();
        this.players = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public boolean addPlayer(String name, int abilityPower) {
        int id = players.size() + 1;
        Player newPlayer = new Player(id, name, abilityPower, 0, 0, null);
        return players.add(newPlayer);
    }

    public boolean addTournament(String name) {
        if (tournaments.stream().anyMatch(t -> t.getName().equals(name))) {
            return false;
        }
        return tournaments.add(new Tournament(name));
    }

    public boolean addTeam(String name) {
        if (teams.stream().anyMatch(t -> t.getName().equals(name))) {
            return false;
        }
        return teams.add(new Team(name));
    }

    public boolean addPlayerToTeam(Player player, Team team) {
        return team.addPlayer(player);
    }
}
