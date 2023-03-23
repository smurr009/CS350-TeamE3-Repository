package edu.odu.cs.cs350.pne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Enrollment_Snapshot
{
    /**
     * Container of Course Offerings
     */
    private List<Offering> Offerings = new ArrayList<>();

    /**
     * Date of Snapshot
     */
    private LocalDate SnapshotDate;
    
    /**
     * Create new Enrollment_Snapshot
     */
    public Enrollment_Snapshot() {
        SnapshotDate = LocalDate.now();
    }

    /**
     * Create new Enorllment_Snapshot
     * @param sDate Date of Snapshot
     */
    public Enrollment_Snapshot(LocalDate sDate){
        SnapshotDate = sDate;
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

    
}
