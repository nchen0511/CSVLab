package sample;

public class App {
    private String status;
    private int missing = 0;


    public App(String status, String dd, String de, String mc) {
        this.status = status;

        if(dd.equalsIgnoreCase("Needed")){
            missing++;
        }
        if(de.equalsIgnoreCase("Needed")){
            missing++;
        }
        if(mc.equalsIgnoreCase("Needed")){
            missing++;
        }
    }

    public String getStatus(){
        return status;
    }

    public int getMissing(){
        return missing;
    }

    @Override
    public String toString() {
        return "[ " + status + " ]" + " Missing Procedures: " + missing;
    }

}