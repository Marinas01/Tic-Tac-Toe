import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// this class is the multy-player game between two players
public class MultiPlayer implements  Game{

    ArrayList<Integer> playerI=new ArrayList<>();
    ArrayList<Integer> playerII=new ArrayList<>();
    ArrayList<Integer> gameBord=new ArrayList<>();
    //this method is the main logic for write the X or 0 in the container or check if a player won or it's a tie
    @Override
    public String play(int index, int id) {


        String answer="";
        if(gameBord.contains(id)){
            return "is taken";
        }
        else{
            gameBord.add(id);
        }

        if(index==1){
            playerI.add(id);
            Collections.sort(playerI);
            if(playerI.size()>=3){
                for(int i=0;i<playerI.size()-2;i++){
                    for(int j=i+1;j<playerI.size()-1;j++){
                        for(int v=j+1;v<playerI.size();v++){
                            int sum=playerI.get(i)+playerI.get(j)+playerI.get(v);
                            if(sum==15||sum==6||sum==24||(playerI.get(i)==playerI.get(j)-3&&playerI.get(j)==playerI.get(v)-3)){
                                for (int a: playerI){
                                    System.out.print(a+" ");
                                }
                                return "Player I won";
                            }

                        }
                    }
                }
            }
            answer= "X";
        }
        else{
            playerII.add(id);
            Collections.sort(playerII);
            if(playerII.size()>=3){
                for(int i=0;i<playerII.size()-2;i++){
                    for(int j=i+1;j<playerII.size()-1;j++){
                        for(int v=j+1;v<playerII.size();v++){
                            int sum=playerII.get(i)+playerII.get(j)+playerII.get(v);
                            if(sum==15||sum==6||sum==24||(playerII.get(i)==playerII.get(j)-3&&playerII.get(j)==playerII.get(v)-3)){

                                for (int a: playerII){
                                    System.out.print(a+" ");
                                }
                                return "Player II won";
                            }

                        }
                    }
                }
            }
            answer= "0";
        }
        if(gameBord.size()==9){
            answer="tie";
        }
        return answer;
    }
}
