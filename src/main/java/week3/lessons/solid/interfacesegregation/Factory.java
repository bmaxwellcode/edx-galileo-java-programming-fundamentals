package week3.lessons.solid.interfacesegregation;

/**
 * Factory - An example of a "fat" interface that violates the Interface
 * Segregation Principle
 * 
 * This interface requires clients to implement many methods, even if they
 * only need a subset of the functionality. This is considered a bad design
 * because:
 * 
 * Problems with fat interfaces:
 * 1. Forces classes to implement methods they don't need
 * 2. Creates artificial dependencies between unrelated functionalities
 * 3. Makes the codebase harder to understand and maintain
 * 4. Increases the impact of changes (ripple effect)
 * 
 * A better approach is to segregate this interface into smaller, more focused
 * interfaces
 * as shown in the other interfaces in this package.
 */
interface Factory {
    // Administrative functions
    public void administration();

    public void accountancy();

    // Production functions
    public void manufacture();

    public void transformRawMaterial();

    // R&D functions
    public void createNewProduct();

    public void costReduction();

    // Logistics functions
    public void logistics();

    public void distribution();
}
