package Tutorial.hasAisA;

class AkademikPerso extends Personel{

    private String unvan;

    public AkademikPerso(){
        System.out.println("Akademik Personel olusturuldu!! adsiz");
    }
    public AkademikPerso(String ad){

        System.out.println("Personel olusturuldu!! "+ ad);
    }
    public void setUnvan(String unvan){
        this.unvan = unvan;
    }
    public String getUnvan(){
        return unvan;
    }

    public void info(){
        System.out.printf("Ben %s %s",unvan,getAdsoy());

    }
}