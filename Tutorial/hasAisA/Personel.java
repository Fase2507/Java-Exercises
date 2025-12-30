package Tutorial.hasAisA;

class Personel{
    private String ad;
    private int maas;
    private String soy;
    static int a=10;
    public Personel(){
//        a=7;
        System.out.println("Personel olusturuldu!! adsiz "+a);
    }
    public Personel(String ad){
        a=3;
        if(ad=="mute")
            return;
        System.out.println("Personel olusturuldu!! "+ ad+a);
    }
    public void setMaas(int maas){
        this.maas = maas;
    }
    public int getMaas(){
        System.out.println("Maas: "+maas);
        return  maas;
    }

    public void setAdsoy(String ad, String soy){
        this.ad = ad;
        this.soy = soy;
    }

    public String getAdsoy(){
        return ad+" "+soy;
    }

    public String toString(){
        return ad.toUpperCase()+" - "+soy.toUpperCase();
    }
    public void info(){
        System.out.printf("Ben %s %s",ad,soy);
    }

}