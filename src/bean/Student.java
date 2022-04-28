package bean;
public class Student{
    private long iD;
    private String name;
    public Student(){

    }

    public Student(long aLong, String string) {
        this.iD=aLong;
        this.name=string;
    }

    public void setID(long iD){
        this.iD = iD;
    }

    public long getID(){
        return iD;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
