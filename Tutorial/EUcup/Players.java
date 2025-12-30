package Tutorial.EUcup;
public class Players{
    private String name_sur;
    private int age;
    private int id;
    private String pos;

    public Players(){
        name_sur = "";
        age = 0;
        id = 0;
        pos = "";
    }
    public Players(int id,String a,int age,  String pos){
        name_sur = a;
        this.age = age;
        this.id = id;
        this.pos = pos;
    }

    public String toString(){
        return this.name_sur+" "+this.age+" "+this.pos;
    }

    public void setName_sur(String name_sur){
        this.name_sur = name_sur;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setId(int id){
        this.id = id ;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getName_sur(){
        return name_sur;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getPos() {
        return pos;
    }


}