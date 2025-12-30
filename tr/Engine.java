package tr;
public class Engine{
        public String type;

        Engine(String type){
            this.type = type;
        }

        void start(){
            System.out.println(type+" is running");
        }
}