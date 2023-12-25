import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Channeling {

    public static int bookChanneling;
    static List<Integer> bookedchannelinglist = new ArrayList<>();//list of booked patient list

    private static Map<Integer, Double> totalCostMap = new HashMap<>(); // Map to store total cost for each patient

    static int treatment = 0;
    static Map<Integer, Patient>patients = new HashMap<>();
    private String appointmentDate;

    public void printchannelingdays(){
        System.out.println("Monday Time: 06.00 pm - 09.00 pm ");
        System.out.println("Wednesday Time: 06.00 pm - 09.00 pm ");
        System.out.println("Saturday Time: 03.00 pm - 10.00 pm");
        System.out.println("Sunday Time: 03.00 pm - 10.00 pm ");
        System.out.println("Thank You");
    }

    public void availabletreatments(){
        System.out.println("1. Cleanings");
        System.out.println("2. Whitening");
        System.out.println("3. Filling");
        System.out.println("4. Nerve Filling");
        System.out.println("5. Root Canal Therapy");
        System.out.println("Be Healthy Forever");
        System.out.println();
    }

    public void bookChanneling(Patient p, String acceptFee, String treatmentOption) {
        boolean feeAccepted = false;
        boolean treatmenttype = false;
        double appointmentfee = 1000; // Base appointment fee
        double treatmenttotalcost = 0;



        if (acceptFee.equals("yes")) {
            feeAccepted = true;
        } else {
            System.out.println("Sorry, you can't book the appointment.");
        }

        if (feeAccepted) {
            // Switch case for handling different treatment options
            switch (treatmentOption) {
                case "Cleaning":
                    // Add code for Cleaning treatment
                    treatmenttotalcost = 1500;
                    System.out.println("Cleaning treatment booked.");
                    break;
                case "Whitening":
                    // Add code for Whitening treatment
                    treatmenttotalcost= 2000;
                    System.out.println("Whitening treatment booked.");
                    break;
                case "Filling" :
                    // Add code for Filling treatment
                    treatmenttotalcost = 2500;
                    System.out.println("Filling treatment booked.");
                    break;
                case "NF":
                    // Add code for Nerve filling treatment
                    treatmenttotalcost = 3000;
                    System.out.println("Nerve filling treatment booked.");
                    break;
                case "RCT":
                    // Add code for Root Canal Therapy
                    treatmenttotalcost = 4000;

                    System.out.println("Root Canal Therapy booked.");

                    break;
                default:
                    System.out.println("Invalid treatment option.");
                    return;  // Exit the method if the treatment option is invalid
            }

            p.setAppointmentDate(appointmentDate);

            double totalCost = appointmentfee + treatmenttotalcost;
            totalCostMap.put(p.getPatientID(), totalCost);

            patients.put(p.getPatientID(), p);
            bookedchannelinglist.add(p.getPatientID());
            System.out.println("Appointment Confirmed Successfully");
        }
    }

    public void printpatients(){
        if(patients.isEmpty()){
            System.out.println("No details of Patients");
            return;
        }
        for (Patient p : patients.values()){
            System.out.println("Patient ID: " + p.patientID);
            System.out.println("Patient Name: "+ p.name);
            System.out.println("Patient Address: " + p.address);
            System.out.println("Phone Number: " + p.phonenumber);
            System.out.println("Channel Day: "+p.channelday);
            System.out.println("Treatment Booked Date: "+ p.getAppointmentDate());
            System.out.println("Treatment Type: " + p.treatmentOption);
            System.out.println("Thank You");
        }
    }

    public void searchAppointment(String searchKey) {
        boolean appointmentFound = false;

        for (Patient patient : patients.values()) {
            if (searchKey.equalsIgnoreCase(patient.getName()) ||
                    searchKey.equalsIgnoreCase(String.valueOf(patient.getPatientID()))) {
                appointmentFound = true;
                System.out.println("Appointment Details for " + searchKey + ":");
                System.out.println("Patient ID: " + patient.getPatientID());
                System.out.println("Patient Name: " + patient.getName());
                System.out.println("Patient Address: " + patient.getAddress());
                System.out.println("Phone Number: " + patient.getPhoneNumber());
                System.out.println("Channeling Day: " + patient.getChannelingDay());
                System.out.println("Treatment Type: " + patient.getTreatmentType());
                System.out.println();
                break;
            }
        }

        if (!appointmentFound) {
            System.out.println("No appointment found for " + searchKey);
        }
    }

    public void viewAppointmentsByDate(String date) {
        boolean foundAppointments = false;

        System.out.println("Appointments on " + date + ":");

        for (Patient patient : patients.values()) {
            if (date.equals(patient.getAppointmentDate())) {
                foundAppointments = true;
                System.out.println("Patient ID: " + patient.getPatientID());
                System.out.println("Patient Name: " + patient.getName());
                System.out.println("Patient Address: " + patient.getAddress());
                System.out.println("Phone Number: " + patient.getPhoneNumber());
                System.out.println("Channeling Day: " + patient.getChannelingDay());
                System.out.println("Treatment Type: " + patient.getTreatmentType());
                System.out.println("Appointment Date: " + patient.getAppointmentDate());
                System.out.println();
            }
        }

        if (!foundAppointments) {
            System.out.println("No appointments on " + date);
        }
    }

    public void updatePatient(int patientID, String newName, String newAddress, int newPhoneNumber,
                              String newChannelingDay, String newTreatmentType) {
        Patient existingPatient = patients.get(patientID);

        if (existingPatient != null) {
            // Update patient details
            existingPatient.setName(newName);
            existingPatient.setAddress(newAddress);
            existingPatient.setPhoneNumber(newPhoneNumber);
            existingPatient.setChannelingDay(newChannelingDay);
            existingPatient.setTreatmentType(newTreatmentType);

            System.out.println("Patient details updated successfully.");
        } else {
            System.out.println("Patient with ID " + patientID + " not found.");
        }
    }

    // Other methods...
    public void paybill(int patientID) {
        Patient patient = patients.get(patientID);

        if (patient != null) {
            double totalCost = totalCostMap.get(patientID);

            System.out.println("Patient's Payment details.");
            System.out.println("Patient ID: " + patient.getPatientID());
            System.out.println("Patient Name: " + patient.getName());
            System.out.println("Phone Number: " + patient.getPhoneNumber());
            System.out.println("Channeling Day: " + patient.getChannelingDay());
            System.out.println("Treatment Type: " + patient.getTreatmentType());
            System.out.println("Total Payment: " + totalCost);
            System.out.println("Thank You");
        } else {
            System.out.println("Patient with ID " + patientID + " not found.");
        }
    }


}
