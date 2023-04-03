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

import java.io.FileReader;

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
     * Create new Enorllment_Snapshot
     * @param sDate Date of Snapshot
     * @param path Path to Snapshot Source File (CSV)
     * @throws IOException
     * @throws CsvValidationException
     */
    public EnrollmentSnapshot(LocalDate sDate, String path_to_csv) 
           throws CsvValidationException, IOException{
        SnapshotDate = sDate;
        if(path_to_csv != "") collectSnapshotData(path_to_csv);
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
        CSVReader reader = new CSVReaderBuilder(new FileReader(path_to_csv)).withSkipLines(1).build();
        String[] nextLine;
        while((nextLine = reader.readNext()) != null) {

        }
    }


    public void addOffering(Offering newOffering) {  }

    
}
