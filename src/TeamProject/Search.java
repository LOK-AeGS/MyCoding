package practice;
import java.util.ArrayList;

/*
인플루언서를 조회하는 기능을 담은 클래스

생성자
public Search(ArrayList<Influencer> listOfInfluencer)

메소드
public ArrayList<Influencer> searching(String[] information, String bound)
 : 조회 버튼을 누른 순간 받아온 각 JTextField들의 String을 배열로, JComboBox들의 String을 배열로 만들어 매개변수로 받아 조회된 인플루언서들을 ArrayList<Influencer>로 반환하는 메소드
 * 반환값: 입력된 값에 의해 조회된 객체들의 ArrayList<Influencer> 배열.
 * 이름이나 범위의 입력이 없을 경우 원본 ArrayList인 listOfInfluencer를 참조하게 됨.

* 이하 메소드는 코드 내부에서 사용
public void searchByName(String name)
public void searchByFollower(int followerBound, String bound)
public void searchByCost(int costBound, String bound)
public void searchByChanceOfAdvertise(int chanceOfAdvertiseBound, String bound)
*/

public class Search {
    ArrayList<Influencer> listOfInfluencer;
    ArrayList<Influencer> searchedList;

    public Search(ArrayList<Influencer> listOfInfluencer) {
        this.listOfInfluencer = listOfInfluencer;
    }

    // GUI의 TextField와 JComboBox에서 받아온 내용 String[] 배열로 엮어서 매개변수로 받아오기.
    public ArrayList<Influencer> searching(String[] information, String[] bound) {
        searchedList = new ArrayList<>();

        if (!(information[0].equals(""))) {
            searchByName(information[0]);
        }
        else if (!information[1].equals("")) {
            searchByFollower(Integer.parseInt(information[1]), bound[0]);
        }
        else if (!information[2].equals("")) {
            searchByCost(Integer.parseInt(information[2]), bound[1]);
        }
        else if (!information[3].equals("")) {
            searchByChanceOfAdvertise(Integer.parseInt(information[3]), bound[2]);
        }
        else {
            searchedList = listOfInfluencer;
        }

        return searchedList;
    }

    public void searchByName(String name) {
        for (int i = 0; i < listOfInfluencer.size(); i++) {
            if(listOfInfluencer.get(i).name.equals(name)) {
                searchedList.add(listOfInfluencer.get(i));
            }
        }
    }

    public void searchByFollower(int followerBound, String bound) {
        if (bound.equals("이상")) {
            for (int i = 0; i < listOfInfluencer.size(); i++) {
                if(listOfInfluencer.get(i).follower >= followerBound){
                    searchedList.add(listOfInfluencer.get(i));
                }
            }
        }
        else { // 이하
            for (int i = 0; i < listOfInfluencer.size(); i++) {
                if(listOfInfluencer.get(i).follower <= followerBound){
                    searchedList.add(listOfInfluencer.get(i));
                }
            }
        }
    }

    public void searchByCost(int costBound, String bound) {
        if (bound.equals("이상")) {
            for (int i = 0; i < listOfInfluencer.size(); i++) {
                if(listOfInfluencer.get(i).cost >= costBound){
                    searchedList.add(listOfInfluencer.get(i));
                }
            }
        }
        else { // 이하
            for (int i = 0; i < listOfInfluencer.size(); i++) {
                if(listOfInfluencer.get(i).cost <= costBound){
                    searchedList.add(listOfInfluencer.get(i));
                }
            }
        }
    }

    public void searchByChanceOfAdvertise(int chanceOfAdvertiseBound, String bound) {
        if (bound.equals("이상")) {
            for (int i = 0; i < listOfInfluencer.size(); i++) {
                if(listOfInfluencer.get(i).chanceOfAdvertise >= chanceOfAdvertiseBound){
                    searchedList.add(listOfInfluencer.get(i));
                }
            }
        }
        else { // 이하
            for (int i = 0; i < listOfInfluencer.size(); i++) {
                if(listOfInfluencer.get(i).chanceOfAdvertise <= chanceOfAdvertiseBound){
                    searchedList.add(listOfInfluencer.get(i));
                }
            }
        }
    }
}