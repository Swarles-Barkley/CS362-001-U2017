/*
 * DateOutOfRangeException.java
 *
 */

package calendar;

public class DateOutOfRangeException extends java.lang.Exception {

    /**
     * Creates new <code>DateOutOfRangeException</code> without detail message.
     */
    public DateOutOfRangeException() {//SEAN: has default behavior Exception parent class, won't prevent bad date from causing further bugs
    }


    /**
     * Constructs an <code>DateOutOfRangeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DateOutOfRangeException(String msg) {
        super(msg);
    }
}


