package Tutorial;
public class VTcon{
    private static VTcon connection;
    //lazy initialization

    private VTcon(){
        System.out.println("Connected!");
    }

    public static VTcon getInstance(){
        if(connection==null){
            connection = new VTcon();
        }
        return connection;
    }

    @Override
    public String toString(){
        return "\r Mssql/MyDB.sql";
    }
}