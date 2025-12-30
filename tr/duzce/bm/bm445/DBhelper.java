package tr.duzce.bm.bm445;
public interface DBhelper{
    String DB_URL = "127.0.0.1";
    int DB_PORT = 4305;
    String DB_SCHEMA_NAME=null;
    String DB_DRIVER = "com.mysql.sj.jdbc.Driver";

    String getFullUrl();
}