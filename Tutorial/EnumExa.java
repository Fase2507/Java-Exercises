
// export PATH="/c/Program Files/Java/jdk-17/bin:$PATH" //to use cli
package Tutorial;
public class EnumExa{
        public enum Il{
            Adana("01","Adana","Akdeniz"),Ankara("06","Ankara","Icanadolu"),Bolu("14","Bolu","Karadeniz");
            private String plakaKodu;
            private String ad;
            private String bolge;

            private Il(String plakaKodu, String ad, String bolge){
                this.plakaKodu = plakaKodu;
                this.ad = ad;
                this.bolge = bolge;
            }
            public String getPlakaKodu(){
                return plakaKodu;
            }
            public String getAd(){
                return ad;
            }
            public String getBolge(){
                return bolge;
            }
        }

        public static void main(String[] args){
            Il il = Il.Bolu;
            System.out.println("Il: "+il.getAd());
            System.out.printf("plaka: %s",il.getPlakaKodu());
            System.out.println();
            System.out.printf("Bolge: %s",il.getBolge());
        }
    }



