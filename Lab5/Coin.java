/*
	Coin.java THIS IS THE ONLY FILE YOU HAND IN
	THERE IS NO MAIN METHOD IN THIS CLASS!
*/
import java.util.Random;
public class Coin
{
  private Random rand;
  private int numHeads;
  private int numTails;
  public Coin(int seed){
    rand = new Random(seed);
    reset();
  }
  public String flip(){
      int num = rand.nextInt(2);
      if(num==0){
        numTails +=1;
        return "T";
      }
      if(num==1){
        numHeads+=1;
        return "H";
      }
      return " ";
  }
  public int getNumHeads(){
      return numHeads;
  }
  public int getNumTails(){
    return numTails;
  }
  public void reset(){
    numHeads = 0;
    numTails = 0;
  }
  public void setNumTails(int setnum){
    numTails= setnum;
  }
  public void setNumHeads(int num){
    numHeads = num;
  }

} // END COIN CLASS
