package edu.odu.cs.cs350.pne;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class EnrollmentSnapshot
{
    private List<Offering> Offerings = new ArrayList<>();
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
     * @param path Path to Snapshot Source File (CSV)
     * @throws IOException
     * @throws CsvValidationException
     */
    public EnrollmentSnapshot(LocalDate sDate, String path_to_csv) 
           throws CsvValidationException, IOException{
        SnapshotDate = sDate;
        collectSnapshotData(path_to_csv);
    }

    /**
     * Get Snapshot Date
     * @return Date of this Snapshot
     */
    public LocalDate getSnapshotDate() { return SnapshotDate; }

    /**
     * Get Number of Offerings in this Snapshot
     * @return Number of Offerings
     */
    public int getNumOfOfferings() { return Offerings.size(); }

    /**
     * Used to Collect Snapshot Data From CSV File
     * Generates A List of Offerings
     * @param path Path to Snapshot Source File (CSV)
     * @throws IOException
     * @throws CsvValidationException
     */
    private void collectSnapshotData(String path_to_csv) 
                 throws CsvValidationException, IOException {
        //CSVReader reader = new CSVReader(new FileReader("TestFile.csv"));
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(path_to_csv))
            .withSkipLines(1).build();
        String[] data;
        while((data = csvReader.readNext()) != null) {
            // MAPPING VARIABLES TO DATA IN CSV FILE
            String CRN = data[1];
            String SUBJ = data[2];
            String CRSE = data[3];
            int XCAP = Integer.parseInt(data[6]);
            int ENR = Integer.parseInt(data[7]);
            String LINK = data[8];
            String GROUP = data[9];
            String INSTRUCTOR = data[20];
            int CAP = 0;
            if(data[22] != "") CAP = Integer.parseInt(data[22]);
            else CAP = XCAP;

            // LINK CONTAINING '1' INDICATES LECTURE SECTION
            // DISREGARD ALL OTHER CASES
            if(LINK.contains("1")) {
                // If GROUP is blank or Offering Does Not Exist
                if(GROUP == "" || !checkForOffering()) {
                    Section section = new Section(SUBJ, CRSE, CRN, XCAP, ENR);
                    Offering offering = new Offering(SUBJ + CRSE, INSTRUCTOR, CAP, GROUP);
                    offering.addSection(section);
                    addOffering(offering);
                } else {

                }
            }            
        }
    }

    public boolean checkForOffering() { 
        return false;
    }

    public void addOffering(Offering newOffering) {
        //if(newOffering.getXlstGroup() == "") {
            Offerings.add(newOffering);
        //}
    }

    public void addSectionToOffering() { }

}
