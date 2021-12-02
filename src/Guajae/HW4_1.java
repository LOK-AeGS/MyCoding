package Guajae;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
//<Student> <T extends Student>//3시간 끝나는데; 3일 걸렸어요ㅋㅋㅋㅋㅋ
class GenericList<T extends Student>{
    //그냥 T 타입으로 받으면 Arrays.sort()에서 오류가 남 CastClass 오류,
    // 근데 Student를 그냥 넣으면 Type parameter 'Student' cannot be instantiated directly오류가 뜸.
    // 그러니 Student만 사용할 수 있도록 <T super Student> (이건 오류남 이유 모르곘다)또는
    // <T extends Student>->부모 클래스에 존재하는 field에 접근이 간으해서 -> Object배열이 안만들어지는거 아닐까
    // name, creditAvg등등 다 접근이 가능ㄴ함를 써야함

    T arr[];
    int count = 0;
    int MAXINDEX;
    //    @SuppressWarnings("unchecked")
    GenericList(){
        MAXINDEX = 10;
        getFile();

    }
    GenericList(int params){
        getFile2(params);

    }
    //<T> -> 제일 상위 클래스가 Object
    //<T extends Student> Student가 제일 상위 클래스
    //Object [] // Student[]
    //
    FileReader fi;
    Scanner sc;
    Student st;
    void getFile() {
        try {//Object[40]; //배열을 한번?
            arr = (T[])new Student[MAXINDEX];//T extends Student의 최상위 클래스는 Student이므로, Object가 아닌 Student로 받아줘야함.
            fi = new FileReader("C:\\Temp\\HW4.txt");
            if(fi != null) {
                sc = new Scanner(fi);
                String lineByLine ;
                while (sc.hasNextLine()) {
                    lineByLine = sc.nextLine();
                    st = new Student(lineByLine.split(","));
                    try {
                        arr[count] = (T) st;
                        count++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        int nextIndex = 0;
                        T[] temp = (T[]) new Student[MAXINDEX];
                        for (int i = 0; i < MAXINDEX; i++) {
                            temp[i] = arr[i];
                        }
                        MAXINDEX = MAXINDEX * 2;
                        arr = (T[]) new Student[MAXINDEX];
                        for (int i = 0; i < MAXINDEX; i++) {
                            arr[i] = temp[i];
                            nextIndex = i;
                        }
                        arr[nextIndex + 1] = (T)st;

                    }
                }
            }//NULLPoint
            int numberOfIndex = -1;
            int ifNullExist = 0;
            for(int i = 0 ; i < arr.length;i++){
                if(arr[i]==null){
                    numberOfIndex = i;//널이 나온
                    ifNullExist = 1;
                    break;
                }
            }
            if(ifNullExist == 1) {
                T [] temp = (T[]) new Student[numberOfIndex];
                for (int i = 0; i < numberOfIndex; i++) {
                    temp[i] = arr[i];
                }
                arr = (T[])new Student[numberOfIndex];
                for(int i = 0 ; i < numberOfIndex ;i++){
                    arr[i] = temp[i];
                }
            }
//            for(int i = 0; i < arr.length; i++){
//                System.out.println("이름"+arr[i].name+" 학번: "+arr[i].stuNum+" 성적: "+arr[i].creditAvg+"");
//
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(fi != null) {
                    fi.close();
                }
            } catch (IOException e) {

                e.printStackTrace();

            }


        }


    }
    void getFile2(int params) {
        try {
            arr = (T[])new Student[params];
            fi = new FileReader("c:\\temp\\HW4_2.txt");
            sc = new Scanner(fi);
            while (sc.hasNextLine()) {
                String lineByLine = sc.nextLine();
                st = new Student(lineByLine.split(","));
                try {
                    arr[count++] = (T) st;
                } catch (ArrayIndexOutOfBoundsException e) {
                    T[] temp = (T[]) new Student[MAXINDEX];
                    for (int i = 0; i < MAXINDEX; i++) {
                        temp[i] = arr[i];
                    }
                    MAXINDEX = MAXINDEX * 2;
                    arr = (T[]) new Student[MAXINDEX];
                    for (int i = 0; i < MAXINDEX; i++) {//10 * 2 20개로 늘려준 다음에 NUll
                        arr[i] = temp[i];
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
    void findError(){
        System.out.println(arr.length);
    }
    compStudent cs;
    void creditSorting(){
        cs = new compStudent();
        cs.setList(1);
//        System.out.println(arr.length);
        Arrays.sort(arr,cs);
        System.out.println("---------------성적 순---------------------");
        for(int i = 0 ; i < arr.length; i++) {
            System.out.println("이름: "+arr[i].name+" 학과: "+arr[i].department+" 학번: "+arr[i].stuNum+" 성적: "+arr[i].creditAvg);
        }
    }

    void nameSorting(){
        cs = new compStudent();
        cs.setList(0);
        Arrays.sort(arr,cs);
        System.out.println("------------이름 순----------------");
        for(int i = 0 ; i < arr.length; i++){
            System.out.println("이름: "+arr[i].name+" 학과: "+arr[i].department+" 학번: "+arr[i].stuNum+" 성적: "+arr[i].creditAvg);
        }

        sc = new Scanner(System.in);

        String nameKey = sc.next(); //binary -> 이름 받아서
        Student Key = null;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i].name.equals(nameKey)){
                Key = new Student(arr[i]);
            }
        }
        int numberOfKey = Arrays.binarySearch(arr,Key,cs);
        System.out.println("이름: "+arr[numberOfKey].name+" 학과: "+arr[numberOfKey].department+" 학번: "+arr[numberOfKey].stuNum+" 성적: "+arr[numberOfKey].creditAvg);
        //교육 목적 ㅋㅋ;


    }

}


//getFile()을 생성자에 넣어 놓고 까먹고 gl.getFile()을 했는데 배열 오류가 떴다 이유는 모르겠음;;

public class HW4_1 {
    public static void main(String args[]){
        GenericList<Student> gl = new GenericList<>();
//        gl.getFile(); file이 닫쳐서 못읽어오는거네 똑똑하시다
        gl.creditSorting();
        gl.nameSorting();
//ㅋㅋㅋㅋㅋ;
    }

}

