import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {
    static int id = 1; //static variable to give id for every new patient
    String name;
    String address;

    int phonenumber;
    String channelday;
    String treatmentOption;
    int patientID; //id of patient created automatically
    String alloted;
    int number;
    int Treatmentfee;
    private String appointmentDate;

    public Patient(String name, String address, int phonenumber, String channelday, String treatmenttype, int treatmentfee){
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.channelday = channelday;
        //this.appointmentDate = appointmentDate;
        this.treatmentOption = treatmenttype;
        this.Treatmentfee = treatmentfee;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.appointmentDate = dateFormat.format(new Date());

        this.patientID = id++;
        alloted = "";
        number = -1;

    }

    // Getter methods for attributes
    public int getPatientID() {
        return patientID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phonenumber;
    }

    public String getChannelingDay() {
        return channelday;
    }

    public String getTreatmentType() {
        return treatmentOption;
    }
    public int getTreatmentfee(){ return Treatmentfee; }
    
    public String getAppointmentDate(){return appointmentDate;}


    public void setName(String newName) {
    }

    public void setAddress(String newAddress) {
    }

    public void setPhoneNumber(int newPhoneNumber) {
    }

    public void setChannelingDay(String newChannelingDay) {
    }

    public void setTreatmentType(String newTreatmentType) {
    }
    public void setTreatmentfee(int newTreatmentfee){

    }

    public void setAppointmentDate(String appointmentDate) {
    }
}
