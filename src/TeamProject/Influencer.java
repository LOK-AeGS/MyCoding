package practice;

/*
인플루언서 클래스

생성자
public Influencer(String[] influencer)
*/

public class Influencer {
    public String name;
    public int follower;
    public int cost;
    public int chanceOfAdvertise;

    public Influencer(String[] influencer) { // 배열을 매개변수로 받는 생성자
        name = influencer[0];
        follower = Integer.parseInt(influencer[1]);
        cost = Integer.parseInt(influencer[2]);
        chanceOfAdvertise = Integer.parseInt(influencer[3]);
    }
}
