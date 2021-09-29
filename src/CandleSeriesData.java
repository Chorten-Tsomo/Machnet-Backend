import java.time.LocalDateTime;


public class CandleSeriesData {
    private LocalDateTime time;
    private String symbol;
    private double price;

    public CandleSeriesData(LocalDateTime time, String symbol, double price){
        this.time =time;
        this.symbol=symbol;
        this.price=price;
    }
    public void setTime(LocalDateTime time){
        this.time=time;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public void setSymbol(String symbol){
        this.symbol=symbol;
    }

    public LocalDateTime getTime(){
        return time;
    }

    public double getPrice(){
        return price;
    }

    public String getSymbol() {
        return symbol;
    }





}