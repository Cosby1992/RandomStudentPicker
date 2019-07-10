package cosby.dk.ungdomsskolen.model;

/**
 * A student currently only consists of a name
 */
public class Student {

    //instance variable
    private String name;


    /**
     * no arg contructor
     */
    public Student() {
    }

    /**
     * Constructor
     * @param name
     */
    public Student(String name) {
        this.name = name;
    }

    ///////////////////////////////////////// GETTERS AND SETTERS //////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
