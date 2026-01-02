package JavaFinal;
import java.time.LocalDate;

public class Major{
    private String name;
    private String webPage;
    private LocalDate foundingDate;

    /*GETTER SETTER METHODS*/

    public String getName() {
        return name;
    }
    public String getWebPage(){
        return webPage;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate foundingDate) {
        if(foundingDate==null||foundingDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException(
                    "Kurulus tarihi bugunden ileri bir tarih ya da bos olamaz.");
        }
        this.foundingDate = foundingDate;
    }

    public void setName(String name) {
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Bölüm adı boş geçilemez!!");
        }
        this.name = name;
    }

    public void setWebPage(String webPage) {
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Web sayfa adı boş geçilemez!!");
        }
        this.webPage = webPage;
    }
}