package Guajae;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//이름 순으로 세팅하고 다시 binarySearch를 써라.
//binarySearch쓰는걸 안써먹음ㅋㅋ;;

class Student{
    String name;
    String department;
    int stuNum;
    double creditAvg;
    Student (Student st){
        this.name = st.name;
        this.department = st.department;
        this.stuNum = st.stuNum;
        this.creditAvg = st.creditAvg;
    }
    Student(String [] lineByLine){
        name = lineByLine[0];
        department = lineByLine[1];
        stuNum = Integer.parseInt(lineByLine[2]);
        creditAvg = Double.parseDouble(lineByLine[3]);
    }
}

//double형을 어떻게 처리할 지가 문제임.
class compStudent implements Comparator<Student> {
    int number;
    public void setList(int number){
        if(number == 0){ // 0번 -> 이름 순
            this.number = 0;
        }
        else{
            this.number = 1; // 1번 -> credit순
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(number == 0){
            return o1.name.compareTo(o2.name);
        }
        else{
            double first = o1.creditAvg * 100;      //0.25같은 걸 일일이 if문을 해줄 수 없으므로, 100을 곱해준 다음 계산을 하자~
            double second = o2.creditAvg * 100;     //소수점 계산은 되도록 * 100같은 걸 해주면 될 듯?
            return (int) (first - second);  //
        }

    }
}
class compStudentName implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Sort extends compStudent{//
    List<Student> al;
    compStudent order;
    Scanner sc;
    Student st;
    //    compStudentName csn;
    Sort(ArrayList<Student> al1){
        al = al1;//타입캐스팅을 해주면 됨. 근데 왜 아직 for()문을 이용해 this.al.add(al1.get(i))가 안되는진 모르겠다.
        order = new compStudent();
        sc = new Scanner(System.in);
//        csn = new compStudentName();
    }
    void takeSortCredit(){
        order.setList(1);
        System.out.println("----------------------학점 순으로 정렬합니다.----------------------");
        Collections.sort(al,order);

        for(int i = 0 ; i < al.size();i++) {
            System.out.println("이름: "+al.get(i).name+" 학과: "+al.get(i).department+" 학번 "+al.get(i).stuNum+" 학점 "+al.get(i).creditAvg);
        }

    }

    void takeSortName(){
        System.out.println("-------------------------이름 순으로 정렬합니다--------------------------");
        order.setList(0);
        Collections.sort(al,order);
        for(int i = 0 ; i < al.size();i++) {
            System.out.println("이름: "+al.get(i).name+" 학과: "+al.get(i).department+" 학번 "+al.get(i).stuNum+" 학점 "+al.get(i).creditAvg);
        }
//        System.out.println("찾으실 이름>>>");
//        Student key = new Student(sc.nextLine().split(","));
//        Student [] temp = new Student[al.size()];
//        for(int i = 0 ; i < al.size(); i++){
//            temp [i] = al.get(i);
//        }
//        int whereIsKey = Arrays.binarySearch(temp,key,order) + 1;
//        System.out.println(key.name+"은 "+whereIsKey+"번 째에 있습니다");
//
//        Object [] temp1;
//        temp1 = al.toArray();
//        System.out.println("찾으실 이름222");
//        String name = sc.next();
//        Arrays.binarySearch(temp1,name);
        System.out.println("찾으실 이름>>>");
        String name = sc.next();
        Student [] temp = new Student[al.size()];
        for(int i = 0 ; i < al.size(); i++){
            temp [i] = al.get(i);
            if(al.get(i).name.equals(name)){
                st = new Student(al.get(i));
            }
            else{
                continue;
            }
        }
        int numberOfSearchResult = Arrays.binarySearch(temp,st,order);
        System.out.println("이름: "+ temp[numberOfSearchResult].name+" 학과: "+temp[numberOfSearchResult].department+" 학번: "+temp[numberOfSearchResult].stuNum+" 학점:"+temp[numberOfSearchResult].creditAvg);

    }

}

class getFile{
    ArrayList<Student> al;//이걸 어디에 둘 지 고민 좀 해봅시다.
    FileReader fi;
    Scanner sc;
    Student student;
    getFile(){
        al = new ArrayList<>();
        try {
            fi = new FileReader("c:\\temp\\HW4.txt");
            sc = new Scanner(fi);
            while(sc.hasNextLine()){
                String lineByLine = sc.nextLine();
                student = new Student(lineByLine.split(","));
                al.add(student);
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                fi.close();
//                for(int i = 0 ; i < al.size(); i++){
//                    System.out.println(al.get(i).name+"  "+al.get(i).department+"  "+al.get(i).stuNum+"  "+al.get(i).creditAvg);
//                }
            }catch(IOException e){

            }

        }
    }

}

class findStudent{
    HashMap<String, Student> hm;
    Scanner sc;
    findStudent(){
        hm = new HashMap<>();
        sc = new Scanner(System.in);
    }

    void findThem(List <Student> al){
        for(int i = 0 ; i < al.size(); i++){
            hm.put(al.get(i).name,al.get(i));
        }
        System.out.println("찾으실 학생의 이름을 입력하십시오.");
        String name = sc.next();
        Student inf = hm.get(name);
        System.out.println("이름: "+inf.name+" 학과: "+inf.department+" 학번: "+inf.stuNum+" 학점: "+inf.creditAvg);
    }

}

class Play{
    getFile gf;
    Sort st;
    findStudent fs;
    Play(){
        gf = new getFile();
        st = new Sort(gf.al);
        st.takeSortCredit();
        st.takeSortName();
        fs = new findStudent();
        fs.findThem(st.al);
    }

}



public class HW4 {

    public static void main(String args[]){

        Play play = new Play();
        GenericList<Student> t = new GenericList<>();
//        t.getFile();
//        t.sorting();

    }


}

