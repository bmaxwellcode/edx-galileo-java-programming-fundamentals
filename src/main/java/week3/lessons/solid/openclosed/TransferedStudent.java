package week3.lessons.solid.openclosed;

/**
 * TransferedStudent - Handles inscription procedure for transfer students
 * 
 * This class implements the Inscription interface to provide the specific
 * behavior needed for transfer student registration. It demonstrates the
 * Open/Closed Principle by extending the system without modifying existing
 * code.
 */
class TransferedStudent implements Inscription {
    private String previousStudies;

    /**
     * Creates a new TransferedStudent instance
     * 
     * @param previousStudies Information about the student's previous academic
     *                        history
     */
    public TransferedStudent(String previousStudies) {
        this.previousStudies = previousStudies;
    }

    /**
     * Creates the paperwork for transfer student inscription
     * 
     * @param ID The procedure ID to assign to the paperwork
     * @return A PaperWork object representing the completed procedure
     */
    @Override
    public PaperWork procedure(int ID) {
        System.out.println("Inscription of Transferred Student");
        // Transfer students require manual processing (automated = false)
        return new PaperWork(ID, false, "InProcess", "Inscription", previousStudies);
    }
}
