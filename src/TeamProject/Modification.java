package practice;

import java.util.ArrayList;

/*
리스트에 인플루언서를 추가, 삭제하는 클래스

생성자
public Modification(ArrayList<Influencer> listOfInfluencer)

메소드
public void add(String[] influencer) : 추가할 인플루언서의 정보를 배열로 받아 ArrayList에 추가하는 메소드
public void add(String name, String follower, String cost, String chanceOfAdvertise) : 추가할 인플루언서의 정보를 String으로 각각 받아 ArrayList에 추가하는 메소드
public void delete(int index) : 삭제할 데이터의 인덱스를 받아 리스트에서 삭제하는 메소드

* add 메소드 오버로딩. 배열 생성 후 사용 or 배열 생성 없이 사용. 둘 중 하나 선택, 사용 후 다른 하나 제거 가능.
*/

public class Modification {
    ArrayList<Influencer> listOfInfluencer;

    public Modification(ArrayList<Influencer> listOfInfluencer){
        this.listOfInfluencer = listOfInfluencer;
    }

    // GUI에서 TextField로 받아온 4개의 String 차례대로 매개변수로 넣어 사용 가능.
    public void add(String name, String follower, String cost, String chanceOfAdvertise) {
        String[] temp = {name, follower, cost, chanceOfAdvertise};
        listOfInfluencer.add(new Influencer(temp));
    }

    // GUI에서는 TextField로 받아온 4개의 String을 배열로 이어준 다음 사용.
    public void add(String[] influencer) {
        listOfInfluencer.add(new Influencer(influencer));
    }

    // GUI의 JList에서 받아온 인덱스로 삭제 처리.
    public void delete(int index){
        listOfInfluencer.remove(index);
    }
}