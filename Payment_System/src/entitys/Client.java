package entitys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String email;
    private Date brthDate; //Data de nascimento

    public Client(String name, String email, Date brthDate) {
        this.name = name;
        this.email = email;
        this.brthDate = brthDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrthDate() {
        return brthDate;
    }

    public void setBrthDate(Date brthDate) {
        this.brthDate = brthDate;
    }

    public String toString(){
        return (name + " " + sdf.format(brthDate) + " - " + email);
    }
}
