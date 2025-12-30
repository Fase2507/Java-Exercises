package Tutorial.EUcup;
class Kupa{
    private Team[] teams;
    public Kupa(){
        this.teams = new Team[26];
    }
    public Kupa(Team[] teams){
        this.teams = teams;
    }

    public Integer OyuncuHesapla(){
        Integer toplam = 0;
        for (Team team: teams){
            toplam+=team.getPlayers().length;

        }
        return toplam;
    }

    public void OyuncuListele(){
//        String[] arr = new String[28];
        StringBuilder sb = new StringBuilder();
        sb.append("\n kupadaki oyuncular: \n");
        Integer idx = 1;
        for (Team team: this.teams){
            for (Players player: team.getPlayers()){
                sb.append(idx).append(".").append(player).append("\n");
                idx++;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] diziler) {
        Players pl1 = new Players(1,"Ali Tekke",24,"GK");
        Players pl2 = new Players(2,"Moli Cekke",19,"LW");
        Players oyuncu3 = new Players(3, "Cristiano Ronaldo", 37,"ST");
        Players oyuncu4 = new Players(4, "Junior Ronaldo", 27,"CF");
        Players[] arr= new Players[] {pl1,pl2};

        Team team1 = new Team(arr,"Ajax");
        Team team2 = new Team(new Players[] {oyuncu3,oyuncu4},"PSV");

        Kupa EUcup = new Kupa(new Team[] {team1,team2});
        System.out.println("Total players: "+ EUcup.OyuncuHesapla());
        EUcup.OyuncuListele();


    }

}