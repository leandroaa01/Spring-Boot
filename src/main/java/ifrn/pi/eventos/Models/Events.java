package ifrn.pi.eventos.Models;

public class Events {
    private String name;
    private String local;
    private String date;
    private String time;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Events [name=" + name + ", local=" + local + ", date=" + date + ", time=" + time + "]";
    }

}
