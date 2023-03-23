package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;

public class testEnrollmentSnapshot {
    LocalDate today = LocalDate.now();
    LocalDate anyDay = LocalDate.of(2023, 1, 16);

    @Test
    public void testDefaultConstructor() {
        Enrollment_Snapshot e1 = new Enrollment_Snapshot();
        assertThat(e1.getSnapshotDate(), is(today));
        assertThat(e1.getNumOfOfferings(), is(0));
    }

    @Test
    public void testNonDefaultConstructor() {
        Enrollment_Snapshot e1 = new Enrollment_Snapshot(anyDay);
        assertThat(e1.getSnapshotDate(), is(anyDay));
        assertThat(e1.getNumOfOfferings(), is(0));
    }
}
