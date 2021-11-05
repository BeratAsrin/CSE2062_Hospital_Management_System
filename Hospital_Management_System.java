import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hospital_Management_System{ // The class that contains main
    public static void main(String[] args){ // Main Class
        Scanner input = new Scanner(System.in); // Scanner object used to take input from user
        int selection; // Used to switch between menus
        String stringselection; // Used to switch between menus
        String inputtoconvert; // Used to switch between menus
        Hospital berzahospital = new Hospital(); // The object that contains hospital's information
        ArrayList<Doctor> doctors = new ArrayList<Doctor>(); // The arraylist that stores dynamically all doctors in the hospital
        ArrayList<Nurse> nurses=new ArrayList<Nurse>(); // The arraylist that stores dynamically all nurses in the hospital
        ArrayList<Patient>patients=new ArrayList<Patient>(); // The arraylist that stores dynamically all patients in the hospital
        mainmenu: // label of main menu
        while(true) { // The while loop that goes until CLOSE PROGRAM is entered.
            clearscreen();
            System.out.println("Welcome to the Hospital Management System ...");
            System.out.println("1- HOSPITAL\n2- DOCTORS\n3- NURSES\n4- PATIENTS\n5- DISEASES\n6- CLOSE PROGRAM");
            try { // To prevent errors in the program in case of wrong input.
                inputtoconvert = input.next();
                selection = Integer.parseInt(inputtoconvert);
            } catch (Exception e) {
                System.out.println("Wrong input try again...");
                continue;
            }
            if (selection == 1) {
                clearscreen();
                berzahospital.revCal(patients); // Revenue of hospital is calculated. 
                berzahospital.showInfo(); // Hospital info is showed.
                System.out.println("Press 0 to see menu");
                try {
                    inputtoconvert = input.next();
                    input.nextLine();
                    selection = Integer.parseInt(inputtoconvert);
                    if (selection == 0) {
                        continue;
                    } else {
                        System.out.println("Wrong entrance please enter 0");
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input try again...");
                }
            } else if (selection == 2) {
                clearscreen();
                System.out.println("1- New Doctor\n2- Doctor info\n3- Show all Doctors\n4- Back to Menu");
                selection = input.nextInt();
                if (selection == 1) {
                    int id;
                    String name;
                    String surname;
                    String address;
                    int age;
                    char gender; 
                    String contactNumber;
                    String contactEmail;
                    String position;
                    String department;
                    clearscreen();
                    do {
                        try {
                            while(true){ 
                                System.out.println("ID: ");
                                inputtoconvert = input.next(); input.nextLine();
                                id = Integer.parseInt(inputtoconvert);
                                if(idcontrol(id, doctors, nurses, patients) == 1){
                                    System.out.println("This ID already added...");
                                    continue;
                                }
                                else{
                                    break;
                                }
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Name: ");
                            name = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Surname: ");
                            surname = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Address: ");
                            address = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Age: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            age = Integer.parseInt(inputtoconvert);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    while (true) {
                        System.out.println("Gender (F/M): ");
                        gender = input.next().charAt(0);
                        if (Character.toUpperCase(gender) == 'F' || Character.toUpperCase(gender) == 'M') {
                            break;
                        } else {
                            System.out.println("Wrong input try again...");
                        }
                    }
                    do {
                        try {
                            System.out.println("Telephone: ");
                            contactNumber = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("E-mail: ");
                            contactEmail = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Enter the number of position: ");
                            String [] positions = {"Doctor","Assistant Doctor","Professor Doctor"};
                            System.out.println("1- "+ positions[0]+"\n2- "+positions[1]+"\n3- "+positions[2]);
                            selection = input.nextInt(); input.nextLine();
                            switch (selection){
                                case 1:
                                    position = positions[0];
                                    break;
                                case 2:
                                    position = positions[1];
                                    break;
                                case 3:
                                    position = positions[2];
                                    break;
                                default:
                                    position = "";
                                    break;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Enter the number of department: ");
                            String [] departments = {"Internal Diseases","Cardiology","Ent(Ear, Nose, and Throat)","Orthopedics","Pediatry"};
                            System.out.println("1- "+ departments[0]+"\n2- "+departments[1]+"\n3- "+departments[2]+"\n4- "+departments[3]+"\n5- "+departments[4]);
                            selection = input.nextInt(); input.nextLine();
                            switch (selection){
                                case 1:
                                    department = departments[0];
                                    break;
                                case 2:
                                    department = departments[1];
                                    break;
                                case 3:
                                    department = departments[2];
                                    break;
                                case 4:
                                    department = departments[3];
                                    break;
                                case 5:
                                    department = departments[4];
                                    break;
                                default:
                                    department = "";
                                    break;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    Doctor newdoctor = new Doctor(id, name, surname, address, age, gender, contactNumber, contactEmail, position,department);
                    doctors.add(newdoctor);
                    Hospital.numberofdoctors++; // It increases the number of doctors in hospital using static variable. 
                } else if (selection == 2) {
                    try {
                        int idOfdoctor;
                        int flag = 0;
                        clearscreen();
                        System.out.println("Enter the doctor ID: ");
                        inputtoconvert = input.next();
                        input.nextLine();
                        idOfdoctor = Integer.parseInt(inputtoconvert);
                        clearscreen();
                        for (Doctor d : doctors) {
                            if (d.id == idOfdoctor) {
                                System.out.println("-----------------------------------------------");
                                d.show();
                                System.out.println("-----------------------------------------------");
                                Collections.sort(d.relatedPatients); //It sorts doctor's patients.
                                System.out.println("Related Patients: ");
                                System.out.println("-----------------------------------------------");
                                d.showallpatients();
                                System.out.println("-----------------------------------------------");
                                Collections.sort(d.relatedNurses); //It sorts doctor's nurses.
                                System.out.println("Related Nurses: ");
                                System.out.println("-----------------------------------------------");
                                d.showallnurses();
                                System.out.println("-----------------------------------------------");
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Could not find that doctor...");
                        }
                        System.out.println("Press 0 to see menu...");
                        selection = input.nextInt(); input.nextLine();
                        if(selection == 0){
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input try again...");
                    }
                } else if (selection == 3) {
                    clearscreen();
                    System.out.println("Doctors:");
                    Collections.sort(doctors);
                    for (Doctor d : doctors) {
                        System.out.println("-----------------------");
                        d.showshort();
                    }
                    try {
                        System.out.println("-----------------------");
                        System.out.println("Press 0 to see menu.");
                        System.out.println("Press 1 to remove doctor.");
                        inputtoconvert = input.next(); input.nextLine();
                        selection = Integer.parseInt(inputtoconvert);
                        if (selection == 0) {
                            continue;
                        }
                        else if(selection == 1){
                            try{
                                int flag=0;
                                System.out.println("Doctor ID: ");
                                inputtoconvert = input.next(); input.nextLine();
                                selection = Integer.parseInt(inputtoconvert);
                                Doctor toRemoved=new Doctor(); // The doctor that will be removed.
                                PersonInfo toTransfered=new Doctor(); // Polymorphism
                                for(Doctor d: doctors){
                                    if(d.getID() == selection){ 
                                        toRemoved=d;
                                        Hospital.numberofdoctors--; // It decreases the number of doctors in hospital using static variable. 
                                        break;
                                    }
                                }
                                boolean isNurseEmpty=toRemoved.relatedNurses.isEmpty(); // Checks the nurse list if it is empty.
                                boolean isEmpty=toRemoved.relatedPatients.isEmpty(); // Checks the patient list if it is empty.
                                if(isEmpty==false) {
                                    for (int i=0; i<doctors.size();i++) {
                                        if (toRemoved.department.equals(doctors.get(i).department)==true && toRemoved.id!=doctors.get(i).id) {
                                            flag = 1;
                                            toTransfered =doctors.get(i) ; // If exists that indicated the doctor to be transferred.
                                            break;
                                        }
                                    }
                                    if (flag == 1) {
                                        System.out.println("The patients have transferred to another doctor"); 
                                        for (Patient p : toRemoved.relatedPatients) {  // The patients of doctor which will be removed.
                                            ( (Doctor)toTransfered).patientenroller(p); // Type casting due to polymorphism.
                                            p.relatedDoctor=(Doctor)toTransfered; // Patients are transferred to new doctor.
                                        }
                                        System.out.println("Press any button to see menu");
                                        input.nextLine();
                                    }
                                    else {
                                        System.out.println("The patients have transferred to another hospital...");
                                        System.out.println("Press any button to see menu");
                                        input.nextLine();
                                        for(Patient p: toRemoved.relatedPatients){ // Patients are removed.
                                            patients.remove(p);
                                        }
                                    }
                                }
                                else{
                                    System.out.println("The doctor has no patients");
                                }
                                if(isNurseEmpty==true){
                                    System.out.println("The doctor has no nurses"); 
                                    
                                }
                                else{
                                    for (Nurse n : toRemoved.relatedNurses) { // The nurses of doctor which will be removed.
                                        ( (Doctor)toTransfered).nurseenrolfler(n); // Type casting due to polymorphism.
                                    }
                                    for(Nurse n:toRemoved.relatedNurses){
                                            n.relateddoctor=(Doctor)toTransfered; // Nurses are transferred to new doctor.
                                    }
                                }
                                doctors.remove(toRemoved);
                                System.out.println("Press any button to see menu"); 
                                input.nextLine();
                            }catch(Exception e){
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input try again...");
                    }
                } else if (selection == 4) {
                    continue;
                } else {
                    System.out.println("Wrong entrance!!!");
                }
            } else if (selection == 3) {
                clearscreen();
                System.out.println("1- New Nurse\n2- Nurse info\n3- Show all Nurses\n4- Back to Menu"); 
                selection = input.nextInt(); input.nextLine(); 
                boolean checkDocList = doctors.isEmpty(); // If there is no doctor in hospital, nurse cannot be added.
                if (selection == 1) {
                    int nurseId;
                    String name;
                    String surname;
                    String address;
                    int age;
                    char gender;  
                    String contactNumber;
                    String contactEmail;
                    Doctor relatedDoctor = new Doctor();
                    clearscreen();
                    if(checkDocList==true){
                        System.out.println("There is no doctor in the List so we cannot insert a Nurse.");
                        System.out.println("Press any button to see menu.");
                        stringselection = input.nextLine();
                        continue mainmenu; // Goes to the mainmenu label.
                    }
                    do {
                        try {
                            System.out.println("ID: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            nurseId = Integer.parseInt(inputtoconvert);
                            if (idcontrol(nurseId, doctors, nurses, patients) == 1) {
                                System.out.println("This ID already added...");
                                continue;
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Name: ");
                            name = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Surname: ");
                            surname = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Address: ");
                            address = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Age: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            age = Integer.parseInt(inputtoconvert);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    while (true) {
                        System.out.println("Gender (F/M): ");
                        gender = input.next().charAt(0);
                        if (Character.toUpperCase(gender) == 'F' || Character.toUpperCase(gender) == 'M') {
                            break;
                        } else {
                            System.out.println("Wrong input try again...");
                        }
                    }
                    do {
                        try {
                            System.out.println("Telephone: ");
                            contactNumber = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("E-mail: ");
                            contactEmail = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    while(true){ // Loop iterates until the id matches with any doctor.
                            System.out.println("Enter the ID of the Related Doctor: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            int doctorId;
                            int flag=0;
                            doctorId = Integer.parseInt(inputtoconvert); 
                            for (int i = 0; i < doctors.size(); i++) {
                                if (doctorId == doctors.get(i).id) {
                                    relatedDoctor = doctors.get(i);
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==1)
                            break;
                    }
                    Nurse newnurse;
                    newnurse = new Nurse(nurseId, name, surname, address, age, gender, contactNumber, contactEmail, relatedDoctor);
                    nurses.add(newnurse);
                    relatedDoctor.nurseenrolfler(newnurse);
                    Hospital.numberofnurses++; // It increases the number of nurses in hospital using static variable.
                }
            else if (selection == 2) {
                    try {
                        int idOfNurse;
                        int flag = 0;
                        clearscreen();
                        System.out.println("Enter the Nurse ID: ");
                        inputtoconvert = input.next();
                        input.nextLine();
                        idOfNurse = Integer.parseInt(inputtoconvert);
                        clearscreen();
                        for (Nurse n : nurses) {
                            if (n.id == idOfNurse) {
                                System.out.println("------------------------------------------------------");
                                n.show();
                                n.showRelateddoctor();
                                flag = 1;
                                System.out.println("------------------------------------------------------");
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Could not find that nurse...");
                        }
                        System.out.println("Press 0 to see menu...");
                        inputtoconvert = input.next(); input.nextLine();
                        selection = Integer.parseInt(inputtoconvert);
                        if(selection == 0){ 
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input try again...");
                    }
                } else if (selection == 3) {
                    clearscreen();
                    System.out.println("Nurses: ");
                    Collections.sort(nurses);
                    for (Nurse n : nurses) {
                        System.out.println("-----------------------");
                        n.showshort();
                    }
                    try {
                        System.out.println("-----------------------");
                        System.out.println("Press 0 to see menu.");
                        System.out.println("Press 1 to remove nurse.");
                        System.out.println("Press 2 to change related doctor.");
                        inputtoconvert = input.next();
                        input.nextLine();
                        selection = Integer.parseInt(inputtoconvert);
                        if (selection == 0) {
                            continue;
                        }
                        else if(selection == 1){ 
                            clearscreen();
                            Nurse toDeleted=new Nurse();
                            System.out.println("Enter nurse ID: ");
                            selection = input.nextInt(); input.nextLine();
                            int i;
                            for(i=0; i<nurses.size();i++){
                                if(nurses.get(i).id==selection){
                                    toDeleted=nurses.get(i); // Doctor to be removed.
                                    break;
                                }
                            }
                            toDeleted.relateddoctor.relatedNurses.remove(toDeleted); // The nurse is removed from the list of nurses of the doctor. 
                            nurses.remove(toDeleted); // Removed from nurse list.
                            Hospital.numberofnurses--; // It decreases the number of nurses in hospital using static variable.
                        }
                        else if(selection == 2){
                            String nurseID;
                            String doctorID;
                            System.out.println("Nurse's ID: "); 
                            nurseID = input.nextLine();
                            System.out.println("Doctor's ID: "); // ID of doctor that the nurse will be transferred. 
                            doctorID = input.nextLine();
                            for(Doctor d: doctors){
                                if(d.getID() == Integer.parseInt(doctorID)){
                                    for(Nurse n: nurses){
                                        if(n.getID() == Integer.parseInt(nurseID)){
                                            d.nurseenrolfler(n); // The nurse is added to the doctor's nurse list.
                                            n.relateddoctor.relatedNurses.remove(n); // Nurse is removed from previous doctor's list. 
                                            n.relateddoctor=d; // Nurse's related doctor is changed.
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                } else if (selection == 4) {
                    continue;
                } else {
                    System.out.println("Wrong entrance!!!");
                }
            } else if (selection == 4) {
                clearscreen();
                System.out.println("1- New Patient\n2- Patient info\n3- Show all Patients\n4- Back to Menu");
                selection = input.nextInt(); input.nextLine();
                boolean checkDocList=doctors.isEmpty();
                if (selection == 1) {
                    int id;
                    int doctorId;
                    String name;
                    String surname;
                    String address;
                    int age;
                    char gender;
                    String contactNumber;
                    String contactEmail;
                    Doctor relatedDoctor = new Doctor();
                    int isInpatient;
                    int numberOfDays=0;
                    clearscreen();
                    if(checkDocList==true){ // Patient cannot be added before any doctor has been added.
                        System.out.println("There is no doctor in the List so we cannot insert a Patient");
                        System.out.println("Press any button to see menu.");
                        stringselection = input.nextLine();
                        continue mainmenu; // Goes to mainmenu label.

                    }
                    do {
                        try {
                            System.out.println("ID: ");
                                inputtoconvert = input.next(); input.nextLine();
                                id = Integer.parseInt(inputtoconvert);
                                if(idcontrol(id, doctors, nurses, patients) == 1){
                                    System.out.println("This ID already added...");
                                    continue;
                                }
                                else{
                                    break;
                                }
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Name: ");
                            name = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Surname: ");
                            surname = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Address: ");
                            address = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Age: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            age = Integer.parseInt(inputtoconvert);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    while (true) {
                        System.out.println("Gender (F/M): ");
                        gender = input.next().charAt(0);
                        if (Character.toUpperCase(gender) == 'F' || Character.toUpperCase(gender) == 'M') {
                            break;
                        } else {
                            System.out.println("Wrong input try again...");
                        }
                    }
                    do {
                        try {
                            System.out.println("Telephone: ");
                            contactNumber = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("E-mail: ");
                            contactEmail = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    while (true){
                            System.out.println("Enter the ID of the Related Doctor: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            int flag=0;
                            doctorId = Integer.parseInt(inputtoconvert);
                            for (int i = 0; i < doctors.size(); i++) {
                                if (doctorId == doctors.get(i).id) {
                                    relatedDoctor = doctors.get(i);
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==1)
                            break;
                    }
                    do {
                        try {
                            System.out.println("Press 1 if the Patient is inpatient Otherwise Press 0: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            isInpatient = Integer.parseInt(inputtoconvert);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    if(isInpatient==1){
                        do {
                            try {
                                System.out.println("Number of Days: ");
                                inputtoconvert = input.next();
                                input.nextLine();
                                numberOfDays = Integer.parseInt(inputtoconvert);
                                break;
                            } catch (Exception e) {
                                System.out.println("Wrong input try again...");
                            }
                        } while (true);
                    }
                    else{
                        numberOfDays=0;
                    }
                    Patient newPatient;
                    newPatient = new Patient(id, name, surname, address, age, gender, contactNumber, contactEmail,isInpatient, numberOfDays,relatedDoctor);
                    patients.add(newPatient); // Patient is added to the patient list.
                    relatedDoctor.patientenroller(newPatient); // Patient is added to the Doctor's patient list.
                }
                else if (selection == 2) {
                    try {
                        int idOfPatient;
                        int flag = 0;
                        clearscreen();
                        System.out.println("Enter the Patient ID: ");
                        inputtoconvert = input.next();
                        input.nextLine();
                        idOfPatient = Integer.parseInt(inputtoconvert);
                        clearscreen();
                        for (Patient p : patients) {
                            if (idOfPatient==p.id) {
                                System.out.println("-----------------------------------------------------");
                                p.show();
                                p.showRelateddoctor();
                                flag = 1;
                                System.out.println("-----------------------------------------------------");
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Could not find that patient...");
                        }
                        System.out.println("Press 0 to see menu...");
                        selection = input.nextInt(); input.nextLine();
                        if(selection == 0 ){
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input try again...");
                    }
                } else if (selection == 3) {
                    clearscreen();
                    Collections.sort(patients);
                    System.out.println("Patients: ");
                    for (Patient p : patients) {
                        System.out.println("-----------------------");
                        p.showshort();
                    }
                    try {
                        System.out.println("-----------------------");
                        System.out.println("Press 0 to see menu.");
                        System.out.println("Press 1 to remove patient.");
                        stringselection = input.nextLine();
                        if (stringselection.equals("0")) {
                            continue;
                        }
                        else if(stringselection.equals("1")){
                            clearscreen();
                            System.out.println("Patient ID: ");
                            stringselection = input.nextLine();
                            for (Patient p : patients) {
                                if(p.getID() == Integer.parseInt(stringselection)){
                                    patients.remove(p); // Patient is removed from patient list
                                    p.relatedDoctor.removepatient(p.getID()); // Patient is removed from the doctor's patient list.
                                }
                            }
                        }
                    } catch (Exception e) {

                    }
                } else if (selection == 4) {
                    continue;
                }

                else {
                    System.out.println("Wrong entrance!!!");
                }
            }
            else if(selection==5){
                clearscreen();
                System.out.println("1- Show all Disease\n2- Back to Menu");
                selection = input.nextInt();input.nextLine();
                if(selection == 1){
                    clearscreen();
                    Disease.showdis();
                    System.out.println("------------------------");
                    System.out.println("Press 0 to see menu");
                    System.out.println("Press 1-5 to see medicines");
                    selection = input.nextInt();input.nextLine();
                    clearscreen();
                    if(selection==1){ 
                        Disease.showmed(1);
                    }
                    else if(selection==2){
                        Disease.showmed(2);
                    }
                    else if(selection==3){
                        Disease.showmed(3);
                    }
                    else if(selection==4){
                        Disease.showmed(4);
                    }
                    else if(selection==5){
                        Disease.showmed(5);
                    }
                    else if(selection==0){
                        continue;
                    }
                    else{
                        System.out.println("Wrong input...");
                    }
                    System.out.println("Press any button to see menu.");
                    selection = input.nextInt(); input.nextLine(); 
                }
                else if(selection == 2){
                    continue;
                }
                else {
                    System.out.println("Wrong entrance!!!");
                }
            }
            else if(selection == 6){
                input.close();
                break;
            }
            else{
                continue;
            }
        }
    }
    public static void clearscreen(){ // Clears the console screen every time it is called.
        System.out.print("\033[H\033[2J"); // ANSI ESCAPE CODE
        System.out.flush();
        //Runtime.getRuntime().exec("cls"); // For Windows Operating System.
    }
    public static int idcontrol(int id, ArrayList<Doctor> doctors, ArrayList<Nurse> nurses, ArrayList<Patient> patients){
        // Checks the all ids that is enrolled in the system, and returns 1 the id exists, returns 0 if the id does not exist.
        for(Doctor d: doctors){
            if(d.getID() == id){
                return 1;
            }
        }
        for(Nurse n: nurses){
            if(n.getID() == id){
                return 1;
            }
        }
        for(Patient p: patients){
            if(p.getID() == id){
                return 1;
            }
        }
        return 0;
    }
}

interface IDate // The interface that stores date data.
{
    void setter(int day, int month, int year); 
    int getDay();
    int getMonth();
    int getYear();
    void showDate();
}

interface IPerson // The interface that stores person data.
{
    public void setter(int id, String name, String surname, String address, int age, char gender, String contactNumber, String contactEmail);
    public void getFullname();
    public void getAddress();
    public void getAge();
    public void getGender();
    public void getcontactNumber();
    public void getcontactEmail();
    public void show();
    public void showshort();
    public int getID();
}

class PersonInfo implements IDate,IPerson{ // The class that stores person data.
    protected int id;
    protected String name,surname; 
    protected String address;
    protected int age;
    protected char gender; // F / M
    protected String contactNumber,contactEmail;
    protected int day;
    protected int month;
    protected int year;
    
    @Override
    public void setter(int id, String name, String surname, String address, int age, char gender, String contactNumber,
            String contactEmail) { // Setter method of personal data.
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
    }

    @Override
    public void getFullname() { 
        System.out.println("Name: " + name + " Surname: " + surname);
    }

    @Override
    public void getAddress() { 
        System.out.println("Address: " + address);
    }

    @Override
    public void getAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void getGender() {
        System.out.println("Gender: " + gender);
    }

    @Override
    public void getcontactNumber() {
        System.out.println("Telephone Number: " + contactNumber);
    }

    @Override
    public void getcontactEmail() {
        System.out.println("E-mail: " + contactEmail);
    }

    @Override
    public void show() { // Shows all the data.
        System.out.println("ID: " + id);
        System.out.println("Name: " + name + " Surname: " + surname);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Telephone Number: " + contactNumber);
        System.out.println("E-mail: " + contactEmail);
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setter(int day, int month, int year) { // Setter method of date.
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void showDate() {
        System.out.println("Day: " + day + "Month: " + month + "Year: " + year);
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void showshort() { // Shows information shortly.
        System.out.println(id + "- " + name + " " + surname);
    }
}

class Doctor extends PersonInfo implements Comparable<Doctor>{ // The class stores doctors' info. 
    protected ArrayList<Patient> relatedPatients = new ArrayList<Patient>();
    protected ArrayList<Nurse> relatedNurses = new ArrayList<Nurse>();
    private String position; 
    String department;
    public Doctor(){  // Empty constructor.

    }
    
    
    public Doctor(int id, String name, String surname, String address, int age, char gender, String contactNumber,
    String contactEmail, String position,String department){ // Constructor. Notice that it is Overload.
        this.position = position;
        this.department=department;
        super.setter(id, name, surname, address, age, gender, contactNumber, contactEmail);
    }

    @Override
    public void showshort() { // Shows information shortly.
        System.out.println(id + "- " + position + " " +name + " " + surname);
    }

    public void patientenroller(Patient toenroll){ // Used to add patient to the doctor.
        relatedPatients.add(toenroll);
    }

    public void nurseenrolfler(Nurse toenroll){ // Used to add nurse to the doctor.
        relatedNurses.add(toenroll);
    }

    public void showallpatients(){ // Shows all patients that is related to the doctor.
        for(Patient p: relatedPatients){
            p.showshort();
        }
    }

    public void removepatient(int id){ // Deletes the patient from the doctor's patient list.
        for(Patient p: relatedPatients){
            if(p.id == id){
                relatedPatients.remove(p);
            }
        }
    }

    public String getPosition(){ // Returns the position of doctor in form of a string.
        return position;
    }

    public void showallnurses(){ // Shows all nurses that is related to the doctor.
        for(Nurse n: relatedNurses){
            n.showshort();
        }
    }

    public void removenurse(int id){ // Deletes the nurse from the doctor's patient list.
        for(Nurse n: relatedNurses){
            if(n.id == id){
                relatedNurses.remove(n);
            }
        }
    }

    @Override
    public void show() { // Shows information of doctor.
        System.out.println("ID: " + id);
        System.out.println("Position: " + position);
        System.out.println("Department: " + department);
        System.out.println("Name: " + name + " Surname: " + surname);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Telephone Number: " + contactNumber);
        System.out.println("E-mail: " + contactEmail);
    }

    @Override
    public int compareTo(Doctor d) { // Compares the ids of two doctor objects.
        int compareId = d.id;
        return this.id - compareId;
    }
}

class Nurse extends PersonInfo implements Comparable<Nurse>{ // The class that stores information of nurses.
    protected Doctor relateddoctor;
    public Nurse(){ // Empty constructor.

    }
    public Nurse(int id, String name, String surname, String address, int age, char gender, String contactNumber,
                 String contactEmail, Doctor relateddoctor){ // Constructor. Notice that it is overload.
        this.relateddoctor = relateddoctor;
        super.setter(id, name, surname, address, age, gender, contactNumber, contactEmail);
    }

    public void changeDoc(Doctor newdoc){ // Changes the doctor of nurse.
        relateddoctor = newdoc;
    }

    public void showRelateddoctor(){ // Shows the doctor that the nurse is related.
        if(relateddoctor.name == null){
            System.out.println("No doctor is attached.");
        }
        else{
        System.out.println(relateddoctor.getPosition() + " " + relateddoctor.name + " " + relateddoctor.surname);
        }
    }

    @Override
    public int compareTo(Nurse n) { // Compares the ids of two nurse objects.
        int compareId = n.id;
        return this.id - compareId;
    }

}

class Patient extends PersonInfo implements Comparable<Patient>{ // The class that stores the data of patient.
    protected int isinpatient;
    protected int numberOfdays;
    protected Doctor relatedDoctor;
    private double basePrice=0;
    private double totalPrice=0;
     Patient(int id, String name, String surname, String address, int age, char gender, String contactNumber,
    String contactEmail, int isinpatient, int numberOfdays, Doctor relatedDoctor){ // Constructor.
        this.isinpatient = isinpatient;
        this.numberOfdays = numberOfdays;
        this.relatedDoctor = relatedDoctor;
        super.setter(id, name, surname, address, age, gender, contactNumber, contactEmail);
        priceCalculator();
    }

    public void baseprices(){ // Used to determine base price that patient has to pay.
        if(relatedDoctor.getPosition().equals("Doctor")){
            basePrice = 50;
        }
        else if(relatedDoctor.getPosition().equals("Assistant Doctor")){
            basePrice = 100;
        }
        else if(relatedDoctor.getPosition().equals("Professor Doctor")){
            basePrice = 150;
        }
    }

    public void showRelateddoctor(){ // Shows the related doctor of patient.
        System.out.println(relatedDoctor.getPosition() + " " + relatedDoctor.name + " " + relatedDoctor.surname);
    }
    public double getTotalprice(){ // Returns total price (in form of double) that patient has to pay.
        baseprices();
        totalPrice = (double)(basePrice + isinpatient * basePrice * numberOfdays);
        return totalPrice;
    }
    public void priceCalculator(){ // Calculates the price that patient has to pay.
        baseprices();
        totalPrice = (double)(basePrice + isinpatient * basePrice * numberOfdays);
    }

    @Override 
    public int compareTo(Patient p) { // Compares ids of two patient objects.
        int compareId = p.id;
        return this.id - compareId;
    }
}

abstract class HospitalInfo{ // The abstract class that stores the data of hospital.
    protected String hospitalname = "Berza Hospital";
    protected String hospitaladdress = "Feneryolu / Istanbul";
    protected int numberofambulances = 3;
    protected String [] departments = {"Internal Diseases","Cardiology","Ent(Ear, Nose, and Throat)","Orthopedics","Pediatry"};
    protected String [] machines = {"MR","X-RAY","UltraSound"};
    protected int bedcapacity = 50;
    public void showInfo(){
    }
}

class Hospital extends HospitalInfo{ // The class that stores the data of hospital.
    static int numberofdoctors=0; 
    static int numberofnurses=0;
    protected double totalRev=0;
    public void revCal(ArrayList<Patient> clients){ // Used to calculate total revenue of hospital.
        totalRev = 0;
        if(numberofdoctors == 0){ // If there is no doctor in hospital total revenue is 0. 
            return;
        }
        else{
            for(Patient p: clients){
                totalRev += (p.getTotalprice());
            }
        }
        
    }

    @Override
    public void showInfo(){ // Shows the hospital information.
        System.out.println("-----------------------------------------------");
        System.out.println("Name: " + hospitalname);
        System.out.println("Address: " + hospitaladdress);
        System.out.println("Ambulances: " + numberofambulances);
        System.out.println("Doctors: " + numberofdoctors);
        System.out.println("Nurses: " + numberofnurses);
        System.out.println("Bed Capacity: " + bedcapacity);
        System.out.println("Total Revenue: " + totalRev);
        System.out.print("Departments: ");
        for(int i=0;i<departments.length;i++){
            if(i==departments.length-1){
                System.out.print(departments[i]);
            }
            else{
                System.out.print(departments[i] + ", ");
            }
        }
        System.out.print("\nMedical Machines: ");
        for(int i=0;i<machines.length;i++){
            if(i==machines.length-1){
                System.out.print(machines[i]);
            }
            else{
                System.out.print(machines[i] + ", ");
            }
        }
        System.out.print("\n");
        System.out.println("-----------------------------------------------");
    }
}

class Disease{ // The class that stores the information about diseases and their medicines.
    static String[][] dis_and_med= {{"Kidney Stone","Rowatinex"},{"Hypertension","Alpha Blocker"},{"Otisis Media","Augmentinin"},
    {"Osteoartriti","Parasetamol"},{"Bronchitis","Broksin"}};
    public static void showdis(){ // Shows the all diseases.
        for(int i=0;i<dis_and_med.length;i++){
            System.out.println((i+1) + "- " + dis_and_med[i][0]);
        }
    }
    public static void showmed(int disnumber){ // Shows the suggested medicine for specific disease.
        disnumber = disnumber-1;
        System.out.println("Suggested medicine for " +dis_and_med[disnumber][0]+" is "+ dis_and_med[disnumber][1] + ".");
    }
}
