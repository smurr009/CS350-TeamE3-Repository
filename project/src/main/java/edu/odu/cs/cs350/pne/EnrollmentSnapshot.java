package edu.odu.cs.cs350.pne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.io.IOException;
import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class EnrollmentSnapshot {
    private List<Offering> Offerings = new ArrayList<>();
    private Set<String> Courses = new HashSet<String>();
    private LocalDate SnapshotDate;
    
    /**
     * Create new Enrollment_Snapshot
     */
    public EnrollmentSnapshot() {
        SnapshotDate = LocalDate.now();
    }

    /**
     * Create new Enrollment_Snapshot
     * @param sDate Date of Snapshot
     * @param path_to_csv Path to Snapshot Source File (CSV)
     * @throws IOException when unable to read from CSV file
     */
    public EnrollmentSnapshot(LocalDate sDate, String path_to_csv) throws IOException {
        SnapshotDate = sDate;
        collectSnapshotData(path_to_csv);
    }

    /**
     * EnrollmentSnapshot Copy Constructor
     * @param src source EnrollmentSnapshot to copy
     */
    public EnrollmentSnapshot(EnrollmentSnapshot src) {
        SnapshotDate = src.SnapshotDate;
        Offerings = src.Offerings;
        Courses = src.Courses;
    }

    /**
     * Get Snapshot Date
     * @return Date of this Snapshot
     */
    public LocalDate getDate() { return SnapshotDate; }

    /**
     * Get Number of Offerings in this Snapshot
     * @return Number of Offerings
     */
    public int getNumOfOfferings() { return Offerings.size(); }

    /**
     * Get All Courses Contained in this Snapshot
     * @return Set of Course Names from this Snapshot
     */
    public Set<String> getCourses() { return Courses; }

    /**
     * Get Total Enrolled Students for Course
     * @param courseName Desired Course Name e.g. "CS350"
     * @return Number of Enrolled Students
     */
    public int getOverallEnrollment(String courseName) {
        int totalEnrolled = 0;
        for(Offering offering: Offerings) {
            if(courseName.equals(offering.getCourseName())){
                totalEnrolled = totalEnrolled + offering.getOverallEnrollment();
            }
        }
        return totalEnrolled;
    }

    /**
     * Get Total Capacity for all Offerings of selected Course
     * @param courseName Desired Course Name e.g. "CS350"
     * @return Overall Capacity of all Offerings of Course
     */
    public int getOverallCap(String courseName) {
        int totalCap = 0;
        for(Offering offering: Offerings) {
            if(courseName.equals(offering.getCourseName()))
                totalCap = totalCap + offering.getOverallCap();
        }
        return totalCap;
    }

    /**
     * Adds an Offering to the collection
     * @param offering the Offering to add
     */
    private void addOffering(Offering offering) {
        Offerings.add(offering);
        Courses.add(offering.getCourseName());
    }

     /**
      *  Check to see if an Offering Exists in the collection
      * @param cName course name e.g. "CS350"
      * @param instr instructor assigned to this offering
      * @param group cross-list group to identify related sections
      * @return True if match found, otherwise false
      */
    private boolean checkForOffering(String cName, String instr, String group) {
        for(Offering offering: Offerings) {
            if(group.equals(offering.getXlstGroup()) && cName.equals(offering.getCourseName()) 
            && instr.equals(offering.getInstructor())) {
                return true;
            }
        }
        return false; // NO MATCH FOUND
    }

    /**
     * Add a Section to an existing Offering
     * @param cName course name e.g. "CS350"
     * @param instr instructor assigned to this offering
     * @param group cross-list group to identify related sections
     * @param section the Section to add
     */
    private void addSectionToOffering(String cName, String instr, String group, Section section) {
        for(Offering offering: Offerings) {
            if(group.equals(offering.getXlstGroup()) && cName.equals(offering.getCourseName()) 
            && instr.equals(offering.getInstructor())) {
                offering.addSection(section);
            }
        }
    }

    /**
     * Used to Collect Snapshot Data From CSV File
     * Generates A List of Offerings
     * @param path_to_csv Path to Snapshot Source File (CSV)
     * @throws IOException when unable to read from CSV file
     */
    public void collectSnapshotData(String path_to_csv) throws IOException {
        try {
            // Read CSV File and Skip Header Line
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(path_to_csv))
                                        .withSkipLines(1).build();
            String[] currentLine;
            // Loop Through All Lines in CSV File
            while((currentLine = csvReader.readNext()) != null) {
                // MAPPING VARIABLES TO DATA IN CSV FILE
                String CRN = currentLine[1];
                String SUBJ = currentLine[2];
                String CRSE = currentLine[3];
                int XCAP = Integer.parseInt(currentLine[6]);
                int ENR = Integer.parseInt(currentLine[7]);
                String LINK = currentLine[8];
                String GROUP = currentLine[9];
                String INSTRUCTOR = currentLine[20];
                int CAP = 0;
                if(currentLine[22] != "") CAP = Integer.parseInt(currentLine[22]);
                else CAP = XCAP;

                // EMPTY LINK OR LINK CONTAINING '1' INDICATES LECTURE SECTION
                // DISREGARD ALL OTHER CASES (LABS OR RECITATION)
                if(LINK == "" || LINK.contains("1")) {
                    // GENERATE NEW OFFERING AND SECTION
                    Offering offering = new Offering(SUBJ + CRSE, INSTRUCTOR, CAP, GROUP);
                    Section section = new Section(SUBJ, CRSE, CRN, XCAP, ENR);
                    // IF GROUP IS BLANK OR OFFERING DOES NOT EXIST
                    if(GROUP == "" || !checkForOffering(SUBJ + CRSE, INSTRUCTOR, GROUP)) {
                        offering.addSection(section);
                        addOffering(offering);
                    } else {
                        addSectionToOffering(SUBJ + CRSE, INSTRUCTOR, GROUP, section);
                    }
                }
            }
        } catch(Exception ex) {
            throw new IOException("Unable to Read CSV File");
        }
    }

    /**
     * Generate clone of this object with deep copy
     * @return clone of this Snapshot
     */
    public EnrollmentSnapshot clone() {
        return new EnrollmentSnapshot(this);
    }

    /**
     * Check for equality between two EnrollmentSnapshots
     * @return True if Equal, False if Not Equal
     */
    public boolean equals(Object rhs) {
        // Check if same object type
        if(!(rhs instanceof EnrollmentSnapshot)) return false;
        // Convert object type to EnrollmentSnapshot
        EnrollmentSnapshot rhsSnapshot = (EnrollmentSnapshot)rhs;
        // Validate EnrollmentSnapshot Data Members
        if(!SnapshotDate.isEqual(rhsSnapshot.SnapshotDate)) return false;
        if(!Courses.equals(rhsSnapshot.Courses)) return false;
        if(getNumOfOfferings() != rhsSnapshot.getNumOfOfferings()) return false;
        return Offerings.equals(rhsSnapshot.Offerings);
    }
}
