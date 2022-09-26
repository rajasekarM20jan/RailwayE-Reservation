import java.util.List;

public class RailwayDatabase {
    String From;
    String To;
    String Train;
    List<String> Timings;
    List<String> Cost;
    RailwayDatabase(){

    }
    public RailwayDatabase(String From,String To,List<String> Timings,List<String>Cost){
        this.From=From;
        this.To=To;
        String Train=From+"to"+To;
        this.Train=Train;
        this.Timings=Timings;
        this.Cost=Cost;
    }
    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public List<String> getTimings() {
        return Timings;
    }
    public String getTrain() {
        return Train;
    }
    public List<String> getCost() {
        return Cost;
    }
}