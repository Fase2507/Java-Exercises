package Tutorial.hasAisA;
public class Motor{
    private boolean calismaDurumu;
    private Integer hiz;

    // constructor
    public Motor(){
        calismaDurumu = false;
        hiz = 0;
    }

    public void Calistir(){
        if(calismaDurumu)
            System.out.println("Motor zaten calisiyor!");
        else
            calismaDurumu = true;
    }

    public void Stop(){
        if (calismaDurumu)
            calismaDurumu = false;
        else
            System.out.println("Motor zaten calismiyor!!");
    }

    public void Hizlan(int miktar){
        if (calismaDurumu)
        {
            System.out.println("Motor hizi "+miktar+" artti!");
            hiz += miktar;
        }
        else
            System.out.println("Once motoru calistir!!");
    }
}