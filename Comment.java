package css.cis3334hailey.vogelladatabase;


/**
 * This class contains the getters and setters relative to the table columns (ID and Comment)
 *
 * @author  Vogella, Hailey Vold
 * @date    3/31/2017
 *
 * @see MySQLiteHelper
 */

public class Comment {
    private long id;
    private String comment;

    /**
     * Getter for ID column, returns ID
     *
     * @return  id
     */
    public long getId() {
        return id;
    }


    /**
     * Setter for ID column, sets ID
     *
     * @param  id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Getter for Comment column, returns comment
     *
     * @return  comment
     */
    public String getComment() {
        return comment;
    }


    /**
     * Setter for comments, sets comment
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     * ToString to Return the comment
     * Will be used by the ArrayAdapter in the ListView
     *
     * @return  comment
     */

    @Override
    public String toString() {
        return comment;
    }
}