import java.util.*;

public class Main
{
    //function for channel booking
    public static void channelbooking(Patient p, String acceptFee, String treatmentOption){
        Channeling channeler = new Channeling();
        channeler.bookChanneling(p, acceptFee, treatmentOption);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        boolean loop = true;
        Channeling channel = new Channeling();
        //loop to get choices from user until he stops
        while (loop){
            System.out.println("1. Channeling Days \n2. Treatment Types \n3. Channel Booking \n4. Booking Patients Details \n5. Search Patient Details\n6. Days Filtered \n7. Update Patient Details \n8. Patient's Bill");
            int choice = scn.nextInt();
            switch (choice){
                //Channeling Days
                case 1:
                {
                    channel.printchannelingdays();
                }
                break;
                //Treatment Types
                case 2:
                {
                    channel.availabletreatments();
                }
                break;
                case 3:
                {
                    System.out.println("Enter your name, address, phone number and Channeling day and Treatment Type");
                    String name = scn.next();
                    String address = scn.next();
                    int phonenumber = scn.nextInt();
                    int treatmentfee = Channeling.bookChanneling;


                    //get channel day
                    System.out.println("Which day you want to book channeling: \n1. Monday \n2. Wednesday \n3. Saturday \n4. Sunday");
                    String channelday = scn.next();
                    //get treatment type
                    System.out.println("Select which number of treatment you want: \n1. Cleaning - 1500/- \n2. Whitening - 2000/- \n3. Filling - 2500/- \n4. Nerve Filling(NF) - 3000/- \n5. Root Canal Therapy(RCT) - 4000/-");
                    String treatmentOption = scn.next();

                    System.out.println("Appointment fee is 1000/-. Do you accept the fee? (yes/no)");
                    String acceptFee = scn.next().toLowerCase();

                    //create patient object
                    Patient p = new Patient(name,address,phonenumber,channelday,treatmentOption,treatmentfee);
                    //channeling
                    channelbooking(p, acceptFee, treatmentOption);
                }
                break;
                case 4:
                {
                    channel.printpatients();
                }
                break;
                case 5:
                {
                    System.out.println("Enter patient ID to show details");
                    int patientID = scn.nextInt();
                    channel.printPatientDetails(patientID);
                }
                break;
                case 6:
                {
                    System.out.println("Enter the day to filter appointments (e.g., Monday, Wednesday):");
                    String filterDay = scn.next();
                    channel.viewAppointmentsByDay(filterDay);
                }
                break;
                case 7: {
                    System.out.println("Enter patient ID to update details:");
                    int updatePatientID = scn.nextInt();
                    System.out.println("Enter new name:");
                    String newName = scn.next();
                    System.out.println("Enter new address:");
                    String newAddress = scn.next();
                    System.out.println("Enter new phone number:");
                    int newPhoneNumber = scn.nextInt();
                    System.out.println("Entere new day you want to book channeling: \n1. Monday \n2. Wednesday \n3. Saturday \n4. Sunday");
                    String newChannelingDay = scn.next();
                    System.out.println("Select which number of treatment you want: \n1. Cleaning \n2. Whitening \n3. Filling \n4. Nerve Filling \n5. Root Canal Therapy(RCT)");
                    String newTreatmentType = scn.next();
                    System.out.println("Appointment fee is 1000/-. Do you accept the fee? (yes/no)");
                    String acceptFee = scn.next().toLowerCase();

                    channel.updatePatient(updatePatientID, newName, newAddress, newPhoneNumber, newChannelingDay, newTreatmentType);
                }
                break;
                case 8:{
                    System.out.println("Enter patient ID to search and display payment details:");
                    int searchPatientID = scn.nextInt();
                    channel.paybill(searchPatientID);
                }
                break;

            }
        }
    }
}