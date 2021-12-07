package practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
파일을 읽고 저장하는 클래스

생성자
public FileReadSave(ArrayList<Influencer> listOfInfluencer)

메소드
public void readDataFile() : 데이터 파일을 읽어서 저장된 데이터를 불러오는 메소드
public void saveDataFile() : 현재 데이터를 데이터 파일에 저장하는 메소드

* readDataFile() 메소드와 saveDataFile() 메소드에서 각각 try-resource-catch 문 예외처리 추가 코드 작성 필요
*/
public class FileReadSave {
    ArrayList<Influencer> listOfInfluencer;; // 인플루언서 ArrayList를 참조할 변수

    public FileReadSave(ArrayList<Influencer> listOfInfluencer) { // 생성자
        this.listOfInfluencer = listOfInfluencer; // 인플루언서 ArrayList 받기
    }

    // 파일에 저장된 데이터를 읽어와서 influencerList에 저장하는 메소드
    public void readDataFile() { // boolean 지우고 void
        try (FileReader fileReader = new FileReader("DataFile3.txt"); // 파일이름 고정
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(","); // 한줄씩 읽기
                listOfInfluencer.add(new Influencer(line)); // influencerList에 저장
            }
        } catch (IOException e) {
            // 예외처리 위해서는 추가 코드 작성 필요
        }
    }

    // influencerList의 데이터를 파일에 저장하는 메소드
    public void saveDataFile() { // boolean 지우고 void
        try (FileWriter fileWriter = new FileWriter("DataFile3.txt")) { // 파일 이름 고정
            for(int i = 0; i < listOfInfluencer.size(); i++) {
                Influencer influencer = listOfInfluencer.get(i);
                fileWriter.write(influencer.name + "," + influencer.follower + "," + influencer.cost + "," + influencer.chanceOfAdvertise + "\n"); // 파일에 정보 쓰기
            }
        } catch (IOException e) {
            // 예외처리 위해서는 추가 코드 작성 필요
        }
    }
}
