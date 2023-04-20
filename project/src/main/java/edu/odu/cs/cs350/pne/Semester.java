package edu.odu.cs.cs350.pne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Semester {
    private String Directory; // Path to Semester Data
    private String SemesterCode; // 6-Digit Code (4-Digit Year + 2-Digit Term)
    private LocalDate PreRegistration;
    private LocalDate AddDeadline;
    private List<EnrollmentSnapshot> Snapshots = new ArrayList<>();
    private Set<LocalDate> SnapshotDates = new HashSet<LocalDate>();
    public boolean lastSnapshot = false;

    /**
     * Create New Semester Object
     * Collects Registration Dates and Generates Snapshots On Creation
     * @param path_to_semester Path to Loaction of Semester Data
     * @throws IOException when insufficent snapshot data is provided
     */
    public Semester(String path_to_semester) throws IOException {
        if(path_to_semester.length() > 6) {
            Directory = path_to_semester;
            ExtractSemesterCode();
            CollectRegistrationDates();
            GenerateSnapshots();
        } else throw new IOException("Invalid Path Provided");
    }

    /**
     * Semester Copy Constructor
     * @param src source Semester to copy
     */
    public Semester(Semester src) {
        Directory = src.Directory;
        SemesterCode = src.SemesterCode;
        PreRegistration = src.PreRegistration;
        AddDeadline = src.AddDeadline;
        Snapshots = src.Snapshots;
        SnapshotDates = src.SnapshotDates;
        lastSnapshot = src.lastSnapshot;
    }
    
    /**
     * Get Directory for Semester
     * @return Directory or Path To Semester Data
     */
    public String getDirectory() { return Directory; }
    
    /**
     * Get Semester Code for this Semester
     * @return Semester Code
     */
    public String getSemesterCode() { return SemesterCode; }

    /**
     * Get Pre-registration Date for this Semester
     * @return Pre-registration Date (Start of Registration Period)
     */
    public LocalDate getPreRegistration() { return PreRegistration; }

    /**
     * Get Add Deadline for this Semester
     * @return Add Deadline Date (End of Registration Period)
     */
    public LocalDate getAddDeadline() { return AddDeadline; }

    /**
     * Get Number of Snapshots in Semester
     * @return Number of Snapshots
     */
    public int getSnapshotCount() { return Snapshots.size(); }
    
    /**
     * Get Semester Name extracted from Semester Code
     * First 4 Characters: Academic Year
     * Last 2 Characters: 10 = Fall, 20 = Spring, 30 = Summer
     * @return Readable Semester Name e.g. "Fall 2020"
     */
    public String getSemesterName() {
        switch(SemesterCode.substring(4)) {
            case "10": return "Fall " + SemesterCode.substring(0, 4);
            case "20": return "Spring " + SemesterCode.substring(0, 4);
            case "30": return "Summer " + SemesterCode.substring(0, 4);
            default: return "";
        }
    }

    public Set<LocalDate> getSnapshotDates() {
        return SnapshotDates;
    }

    /**
     * Get Latest Snapshot up to date provided
     * @param target_date date of interest
     * @return the EnrollmentSnapshot on or directly before the date
     */
    public EnrollmentSnapshot getSnapshot(LocalDate target_date) {
        EnrollmentSnapshot snapshot_match = new EnrollmentSnapshot();
        for(EnrollmentSnapshot snapshot: Snapshots) {
            if(target_date.isAfter(snapshot.getDate()) || 
                target_date.isEqual(snapshot.getDate())) {
                    snapshot_match = snapshot.clone();
            }
        }
        return snapshot_match;
    }

    /**
     * Used to Extract 6-Digit Semester Code from Semester Directory
     * Enforces requiremnt for "/" at the end of Directory Path
     */
    private void ExtractSemesterCode() {
        int dir_length = Directory.length();
        if(Directory.endsWith("/")) {
            SemesterCode = Directory.substring(dir_length - 7, dir_length - 1);
        } else {
            SemesterCode = Directory.substring(dir_length - 6);
            Directory = Directory + "/";
        }
    }

    /**
     * Used to Extract Registration Dates from "dates.txt" for Semester
     * @throws IOException if "dates.txt" is not found
     */
    private void CollectRegistrationDates() throws IOException {
        try {
            BufferedReader txtFile = new BufferedReader(new FileReader(Directory+"dates.txt"));
            PreRegistration = LocalDate.parse(txtFile.readLine());
            AddDeadline = LocalDate.parse(txtFile.readLine());
            txtFile.close();
        } catch(IOException ex) {
            throw new IOException("Missing dates.txt in " + SemesterCode);
        }
    }

    /**
     * Generates List of Snapshots for the Semester
     * Finds All CSV Files in Directory and Creates Snapshots
     * Excludes Snapshots before pre-registration and all but 1 after Add Deadline
     * @throws IOException for problems reading CSV Files
     */
    private void GenerateSnapshots() throws IOException {
        File[] files = new File(Directory).listFiles();
        for(File file: files) {
            try {
                if(IncludeSnapshotCSV(file)) InsertSnapshot(file);
            } catch(Exception ex) { 
                throw new IOException("Problem Reading " + file.getName());
            }
        }
    }

    /**
     * Converts a filename into Date
     * @param filename Filename to be parsed (must end with ".csv")
     * @return LocalDate extracted from filename
     */
    private LocalDate DateFromFilename(String filename) {
        return LocalDate.parse(filename.replace(".csv", ""));
    }

    /**
     * Validates Snapshots to be included in Semester
     * Snapshots taken prior to pre-registration are invalid
     * Snapshots taken after add deadline, except first one, are invalid
     * @param file a file from the semester directory
     * @return True if snapshot is to be included
     */
    private Boolean IncludeSnapshotCSV(File file) {
        // Check for valid file
        if(!file.isFile()) return false;
        // Check filename ends with ".csv"
        if(!file.getName().toLowerCase().endsWith(".csv")) return false;
        LocalDate csv_date = DateFromFilename(file.getName());
        // Check date is after pre-registration
        if(csv_date.isBefore(PreRegistration)) return false;
        // Check If After Add Deadline and A Final Snapshot Has Not Been Found
        if(csv_date.isAfter(AddDeadline) && lastSnapshot == true) return false;
        // Valid Snapshot to be Included
        return true;
    }

    /**
     * Inserts New Snapshot into Snapshot Container
     * @param file verified "csv" file to be inluded
     * @throws Exception if unable to read snapshot data
     */
    private void InsertSnapshot(File file) throws IOException {
        // Get Snapshot Date and CSV Path
        LocalDate snapshotDate = DateFromFilename(file.getName());
        String path_to_csv = Directory + file.getName();
        // Add New Snapshot to Snapshot Collection
        Snapshots.add(new EnrollmentSnapshot(snapshotDate, path_to_csv));
        SnapshotDates.add(snapshotDate);
        // When snapshotDate is after Add Deadline, the last snapshot has been found
        if(snapshotDate.isAfter(AddDeadline)) lastSnapshot = true;
    }

    /**
     * Generate clone of this object with deep copy
     * @return clone of this Semster
     */
    public Semester clone() {
        return new Semester(this);
    }

    /**
     * Check for equality between two Semesters
     * @return Ture if Equal, False if Not Equal
     */
    public boolean equals(Object rhs) {
        // Check if same object type
        if(!(rhs instanceof Semester)) return false;
        // Convert object type to Semester
        Semester semester = (Semester)rhs;
        // Validate Semester Data Members
        if(!Directory.equals(semester.Directory)) return false;
        if(!SemesterCode.equals(semester.SemesterCode)) return false;
        if(!PreRegistration.isEqual(semester.PreRegistration)) return false;
        if(!AddDeadline.isEqual(semester.AddDeadline)) return false;
        if(!SnapshotDates.equals(semester.SnapshotDates)) return false;
        return Snapshots.equals(semester.Snapshots);
    }
}
