package week3.lessons.solid.openclosed;

/**
 * PaperWork - Represents a university administrative procedure
 * 
 * This class stores information about a specific university procedure,
 * such as a student inscription, course assignment, etc.
 */
class PaperWork {
    private int ID;
    private boolean automated;
    private String state;
    private String typeOfProcedure;
    private String information;

    /**
     * Creates a new PaperWork instance
     * 
     * @param id              The procedure ID number
     * @param automated       Whether this procedure is processed automatically
     * @param state           Current state (e.g., "InProcess", "Approved",
     *                        "Rejected")
     * @param typeOfProcedure Type of administrative procedure (e.g., "Inscription")
     * @param information     Additional information relevant to the procedure
     */
    public PaperWork(int id, boolean automated, String state, String typeOfProcedure, String information) {
        this.ID = id;
        this.automated = automated;
        this.state = state; // "InProcess" "Approved" "Rejected"
        this.typeOfProcedure = typeOfProcedure; // "Inscription" "AssignCourses" "UnassignCourse" ...
        this.information = information; // Additional data to store
    }

    /**
     * Returns a string representation of this PaperWork
     * 
     * @return A formatted string with the procedure's details
     */
    @Override
    public String toString() {
        return this.ID + " " + this.state + " " + typeOfProcedure + " " +
                ((automated) ? "Automated" : "Manual") +
                "\n\t" + this.information;
    }
}
