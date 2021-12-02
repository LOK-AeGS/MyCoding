package practice;
import java.util.ArrayList;
import java.util.Scanner;

class influencer{
    public String name;
    public int follower;
    public int cost;
    public int chanceOfAdvertise;
    public influencer(){

    }
}

public class Search {
    Scanner sc;
    ArrayList<influencer> listOfInfluencer;
    public Search(ArrayList<influencer> listOfInfluencer){
        sc = new Scanner(System.in);
        this.listOfInfluencer = listOfInfluencer;       //shallow copy
    }
    //if(name.equals(""))를 쓰면 넘어가버려서
    public void searchByName(String name){
        //버튼을 눌렀을 때 배열 index[0]에 이름이 들어가 있으면 - > searchByName 호출
        //이름 이름 조회
        //이름 조회
        //if(txtField1.getSource() == ""){}else if(txtField2.getSource() == ){}
        //
        //[4] -> 0번째는 무조건 이름 1번째는 팔로워 수 문자가 비어져있다 그러면 NULL Point? or ""로 처리?
        //
        //for(int i = 0 ; i < 4 ; i ++){}
//        for(int i = 0 ; i < listOfInfluencer.size() ; i++){
//            if(listOfInfluencer.get(i).name.equals(name)){
//                System.out.println("이름: "+listOfInfluencer.get(i).name+" 팔로워 수: "+listOfInfluencer.get(i).follower+
//                        " 광고 횟수: "+listOfInfluencer.get(i).chanceOfAdvertise+" 광고 비용: "+listOfInfluencer.get(i).cost);
//            }
//        }
        searchMethod(1,name,0,0,0);
        
    }   //기억하고 있어보세요 모든 친구들 다 데려와서 이상, 이하 판별

    public void searchMethod(int number, String name,int followerBound,int chanceBound ,int costBound){
        ArrayList<influencer> sortedList = new ArrayList<>();
        for(int i = 0 ; i < listOfInfluencer.size() ; i++){
            if(number == 1){                                        //1번 -> 이름
                if(listOfInfluencer.get(i).name.equals(name)){
                    System.out.println();
                    break;
                }
            }else if(number == 2){                                  //2번 -> follower 이상.
                if(listOfInfluencer.get(i).follower >= followerBound){
                    sortedList.add(listOfInfluencer.get(i));
                }
            }else if(number == 3){                                  //3번 -> follower 이하.
                if(listOfInfluencer.get(i).follower <= followerBound){
                    sortedList.add(listOfInfluencer.get(i));
                }
            }else if(number == 4){                                  //4번 -> chanceOfAdv 이상
                if(listOfInfluencer.get(i).chanceOfAdvertise >= chanceBound){
                    sortedList.add(listOfInfluencer.get(i));
                }
            }else if(number == 5){                                  //5번 -> chanceOfAdv 이하
                if(listOfInfluencer.get(i).chanceOfAdvertise <= chanceBound){
                    sortedList.add(listOfInfluencer.get(i));
                }
            }else if(number == 6){                                  //6번 -> cost 이상
                if(listOfInfluencer.get(i).cost >= costBound){
                    sortedList.add(listOfInfluencer.get(i));
                }

            }else if(number == 7){                                  //7번 -> cost 이하
                if(listOfInfluencer.get(i).cost <= costBound){
                    sortedList.add(listOfInfluencer.get(i));
                }
            }

        }
        for(int i = 0 ; i < sortedList.size(); i++){
            System.out.println("이름: "+sortedList.get(i).name+" 팔로워 수: "+sortedList.get(i).follower+
                    " 광고 횟수: "+sortedList.get(i).chanceOfAdvertise+" 광고 비용: "+sortedList.get(i).cost);
        }
    }

    public void searchByFollower(int bound){
        //
        //수 입력받고
        //1. 이상
        //2. 이하
        System.out.println("1.이상, 2.이하");
        int option = sc.nextInt();
        if(option == 1){
            searchMethod(2,"",bound,0,0);

        }
        else if(option == 2){
            searchMethod(3,"",bound,0,0);
        }



    }//

    public void searchByChanceOfAdvertise(int bound){
        System.out.println("1.이상, 2.이하");
        int option = sc.nextInt();
        if(option == 1){
            searchMethod(4,"",0,bound,0);

        }
        else if(option == 2){
            searchMethod(5,"",0,bound,0);
        }


    }

    public void searchByCost(int bound){
        System.out.println("1.이상, 2.이하");
        int option = sc.nextInt();
        if(option == 1){
            searchMethod(6,"",0,0,bound);

        }
        else if(option == 2){
            searchMethod(7,"",0,0,bound);
        }
    }

    public static void main(String args[]){



    }




}
