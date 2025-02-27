package Tournament;

public class Player {
    private int id;
    private String name;
    private int abilityPower;
    private int gamesWon;
    private int gamesLost;
    private Team team;

    public Player(int id, String name, int abilityPower, int gamesWon, int gamesLost, Team team) {
        this.id = id;
        this.name = name;
        this.abilityPower = abilityPower;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAbilityPower() {
        return abilityPower;
    }

    public void setAbilityPower(int abilityPower) {
        this.abilityPower = abilityPower;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void winGame() {
        this.gamesWon++;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void loseGame() {
        this.gamesLost++;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String showStats() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abilityPower=" + abilityPower +
                ", gamesWon=" + gamesWon +
                ", gamesLost=" + gamesLost +
                ", team=" + (team != null ? team.getName() : "No Team") +
                '}';
    }
}
