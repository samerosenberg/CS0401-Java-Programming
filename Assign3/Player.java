public class Player{
  String name;
  int wins;
  int losses;
  int rounds;
  public Player(String n){
    name = n;
    wins = 0;
    losses = 0;
    rounds = 0;
  }
  public Player(String n, int r, int w, int l){
    name= n;
    rounds = r;
    wins = w;
    losses = l;
  }
  public int getWins(){
    return wins;
  }
  public int getLosses(){
    return losses;
  }
  public int getRounds(){
    return rounds;
  }
  public String getName(){
    return name;
  }
  public void setWins(int n){
    wins = n;
  }
  public void setLosses(int n){
    losses =n;
  }
  public void setRounds(int n){
    rounds =n;
  }
  public void setName(String n){
    name= n;
  }
  public String toString(){

  }
}
