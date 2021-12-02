package Guajae;

import java.util.ArrayList;
import java.util.Scanner;

// static ArrayList를 쓰는게 더 현명했을 듯함;;
// 근데 나의 빡 대가리 짓으로 그걸 말을 안 해줬었네 ㅋㅋ;;
// 다시 생각해보니 shallow copy를 사용하면 참조하기 때문에 복사한 배열을 건드려도 원 배열까지 바뀜

class influencer{
    public String name;
    public int follower;
    public int cost;
    public int chanceOfAdvertise;
}

public class modification {
    ArrayList<influencer> listOfInfluencer;
    Scanner sc;

    public modification(ArrayList<influencer> listOfInfluencer){
        sc = new Scanner(System.in);

        this.listOfInfluencer = listOfInfluencer;//shallow copy를 이용합니다. -> modification 안에 있는 배열을 건드리면 원래 배열 또한 바뀜.

        System.out.println("1.삭제 2.추가");
        int option = sc.nextInt();
        if(option == 1){
            delete();
        }
        else if(option == 2){
            add();
        }
        else{
            System.out.println("잘 못 입력하셨습니다.");
        }
//
    }

    public void show(){
        for(int i = 0 ; i < listOfInfluencer.size(); i++){
            System.out.println("이름: "+listOfInfluencer.get(i).name+" 팔로워 수: "+listOfInfluencer.get(i).follower
            + "광고 비용: "+listOfInfluencer.get(i).cost+" 광고 횟수: "+listOfInfluencer.get(i).chanceOfAdvertise);
        }

    }

    public void delete(){
        System.out.print("삭제할 인플루언서의 이름을 입력하십시오.>>");
        String name = sc.next();
        for(int i = 0 ; i < listOfInfluencer.size(); i++){
            if(listOfInfluencer.get(i).name.equals(name)){
                listOfInfluencer.remove(i);
            }

        }

        System.out.println("----------삭제가 완료 되었습니다.-----------");
        show();

    }

    public void add(){
        System.out.print("추가할 인플루언서의 이름,팔로워 수,광고 비용,광고 횟수를 입력해주십시오>>>");
        sc.nextLine();
        String influencer = sc.nextLine();
        String [] temp = influencer.split(",");
        influencer tempInfluencer = new influencer();
        tempInfluencer.name = temp[0];
        tempInfluencer.follower = Integer.parseInt(temp[1]);
        tempInfluencer.cost = Integer.parseInt(temp[2]);
        tempInfluencer.chanceOfAdvertise = Integer.parseInt(temp[3]);
        listOfInfluencer.add(tempInfluencer);
        System.out.println("--------추가 되었습니다.---------");
        show();

    }

    public static void main(String args[]){
        ArrayList<influencer> listOfInfluencer = new ArrayList<>();
        influencer ahn = new influencer();
        ahn.name = "안균승";
        ahn.chanceOfAdvertise = 10;
        ahn.cost = 100;
        ahn.follower = 248;
        listOfInfluencer.add(ahn);
        influencer han = new influencer();
        han.name = "김길태";
        han.chanceOfAdvertise = 10;
        han.cost = 100;
        han.follower = 248;
        listOfInfluencer.add(han);
        modification md = new modification(listOfInfluencer);



    }

}
