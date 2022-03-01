public class sss {

    public static void main(String[] args) {
        for (int i=0;i<4;i++){
            System.out.print (i);
            if(i==3){
                for(int x =i ;x>=0;x--,i--){
                    System.out.print (i);
                }
            }
        }
        System.out.print ("sss");
    }
}
