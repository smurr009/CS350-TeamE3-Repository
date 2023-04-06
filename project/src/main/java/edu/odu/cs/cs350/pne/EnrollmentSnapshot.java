package edu.odu.cs.cs350.pne;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class EnrollmentSnapshot
{
    private List<Offering> Offerings = new ArrayList<>();
    private Set<String> courses;
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
    public EnrollmentSnapshot(LocalDate sDate, String path_to_csv) throws Exception {
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
    private void collectSnapshotData(String path_to_csv) throws Exception {
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
                    addSectionToOffering(GROUP, section);
                }
            }
        }
    }

    /**
     * Check to see if an Offering with Xlist Group Exists in Snapshot
     * @param group cross-list group to identify related sections
     * @return True if match found, otherwise false
     */
    public boolean checkForOffering(String cName, String instr, String group) {
        for(Offering offering: Offerings) {
            if(group != "" && group.equals(offering.getXlstGroup())) return true;
        }
        // No Matching Offering Was Found
        return false;
    }

    private void addOffering(Offering newOffering) {
        Offerings.add(newOffering);
    }

    private void addSectionToOffering(String group, Section newSection) {
        for(Offering offering: Offerings) {
            if(group != "" && group.equals(offering.getXlstGroup())){
                offering.addSection(newSection);
            }
        }
    }

}
