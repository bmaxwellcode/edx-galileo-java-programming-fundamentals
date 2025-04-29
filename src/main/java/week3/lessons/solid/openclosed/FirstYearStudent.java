package week3.lessons.solid.openclosed;

/**
 * FirstYearStudent - Handles inscription procedure for new students
 * 
 * This class implements the Inscription interface to provide the specific
 * behavior needed for first-year student registration. It demonstrates the
 * Open/Closed Principle by extending the system without modifying existing
 * code.
 */
class FirstYearStudent implements Inscription {
    private String personalIdentityDocument;

    /**
     * Creates a new FirstYearStudent instance
     * 
     * @param personalIdentityDocument The student's identity document information
     */
    public FirstYearStudent(String personalIdentityDocument) {
        this.personalIdentityDocument = personalIdentityDocument;
    }

    /**
     * Creates the paperwork for first-year student inscription
     * 
     * @param ID The procedure ID to assign to the paperwork
     * @return A PaperWork object representing the completed procedure
     */
    @Override
    public PaperWork procedure(int ID) {
        System.out.println("Inscription of New Student");
        // First-year students require manual processing (automated = false)
        return new PaperWork(ID, false, "InProcess", "Inscription", personalIdentityDocument);
    }
}
