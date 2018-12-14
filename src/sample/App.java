package sample;

public class App {
    private String status;
    private int complete = 0;


    public App(String status, String dd, String de, String mc) {
        this.status = status;

        if(dd.equalsIgnoreCase("Complete")){
            complete++;
        }
        if(de.equalsIgnoreCase("Complete")){
            complete++;
        }
        if(mc.equalsIgnoreCase("Complete")){
            complete++;
        }
    }

    public String getStatus(){
        return status;
    }

    public int getComplete(){
        return complete;
    }

    @Override
    public String toString() {
        return "[ " + status + " ]" + " Completed Procedures: " + complete;
    }

}