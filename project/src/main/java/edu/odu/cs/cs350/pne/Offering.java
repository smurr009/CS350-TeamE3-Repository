package edu.odu.cs.cs350.pne;

import java.util.ArrayList;
import java.util.List;

public class Offering {
    private List<Section> sections = new ArrayList<>();
    private int OverallCap;

    public Offering() {
        OverallCap = 0;
    }

    public Offering(int cap) {
        OverallCap = cap;
    }

    public int getNumOfSections() { return sections.size(); }
    public int getOverallCap() { return OverallCap; }

    public int getOverallEnrollment() { 
        int TotalEnrollment = 0;
        for(Section sect: sections) 
            TotalEnrollment = TotalEnrollment + sect.getEnrolled();
        return TotalEnrollment;
    }

    public Section getSectionByCRN(String CRN) {
        for(Section sect: sections)
            if(CRN == sect.getCRN()) return sect;
        return null;
    } 

    public void setOverallCap(int cap) { OverallCap = cap; }
    public void addSection(Section sect) { sections.add(sect); }

}
