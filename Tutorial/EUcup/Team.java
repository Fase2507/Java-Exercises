package Tutorial.EUcup;

class Team{
    private String name;
    private Players[] players ;

    public Team(){
        this.name = "";
        this.players = new Players[26];
    }
    public Team(Players[] players, String n){
        this.players = players;
        name = n;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPlayers(Players[] players) {
        this.players = players;
    }
    public Players[] getPlayers(){
        return players;
    }
}