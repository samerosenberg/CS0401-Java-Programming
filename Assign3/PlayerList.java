import java.util.*;

public class PlayerList{
  private ArrayList<Player> players = new ArrayList<Player>();
  public PlayerList(String str){
    Scanner scan = new Scanner(str);
    while(scan.hasNextLine()){
      players.add(new Player(scan.next(),scan.nextInt(),scan.nextInt(),scan.nextInt()));
    }
  }
  public Player getPlayer(String name){
    for(int i=0;i<players.size();i++){
      if(players.get(i).getName().equals(name))
        return players.get(i);
    }
  }
  public void addPlayer(Player p){
    players.add(p);
  }
  public void removePlayer(String name){
    for(int i=0;i<players.size();i++){
      if(players.get(i).getName().equals(name))
        players.remove(i);
    }
  }
  public String toStringAdmin(){

  }
}
