package week3.lessons.solid.openclosed;

/**
 * ReEntryStudent - Handles inscription procedure for returning students
 * 
 * This class implements the Inscription interface to provide the specific
 * behavior needed for re-entry student registration. It demonstrates the
 * Open/Closed Principle by extending the system without modifying existing
 * code.
 */
class ReEntryStudent implements Inscription {
    private String studentId;

    /**
     * Creates a new ReEntryStudent instance
     * 
     * @param studentId The returning student's ID number
     */
    public ReEntryStudent(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Creates the paperwork for re-entry student inscription
     * 
     * @param ID The procedure ID to assign to the paperwork
     * @return A PaperWork object representing the completed procedure
     */
    @Override
    public PaperWork procedure(int ID) {
        System.out.println("Inscription of Re-Entry Student");
        // Re-entry students can be processed automatically (automated = true)
        return new PaperWork(ID, true, "InProcess", "Inscription", studentId);
    }
}
