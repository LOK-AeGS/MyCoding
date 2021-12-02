package BaekJoon.InputNarithmeticOper;

public class woni {
    public static void main(String args[]){
        String arr[] = new String[5];
        for(int i = 0 ; i < 4 ; i++){
            arr[i] = "1";
        }
        for(int i = 0 ; i < 5 ; i++) {
            System.out.println(arr[i]);
        }

    }
}

class human{

    String name;
    int age;
    double height;


    public human(String name, int age, double height){

        this.name = name;
        this.age = age;
        this.height = height;

        eye e = new eye("blue");
        heart h = new heart(130);
        brain b = new brain(100);
        blood p = new blood(170);
    }
}


class eye{
    String eyeColor;
    public eye(String eyecolor){
        eyeColor = eyecolor;
    }

}
class heart{
    int heartBeat;
    public heart(int heartbeat){
        heartBeat = heartbeat;
    }


}
class brain{
    double IQ;
    public brain(double Iq){
        IQ = Iq;
    }
}
class blood{
    int pressure;
    public blood(int presure){
        pressure = presure;
    }

}





//절차지향언어 -> C언어

//객체지향언어 -> Java!!


