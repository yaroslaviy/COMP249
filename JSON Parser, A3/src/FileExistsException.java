// -----------------------------------------------------
// Assignment 3
// Written by: Yaroslav Bilodid ID#40068605
// -----------------------------------------------------



import java.io.File;


/**
 * The Class FileExistsException.
 * Yaroslav Bilodid ID#40068605
 * COMP249
 * Assignment # 3
 * Due Date 21-03-2019
 */
public class FileExistsException extends Exception{

	/**
	 * Constructor with custom message
	 */
	public FileExistsException(String message) {
		super(message);
	}
	
	/**
	 * Default constructor
	 *
	 * @param result the file that exists already
	 * 
	 */
	public FileExistsException(File result) {
		super("\nThere is already an existing file for that author with the name: "
				+ result.getName() + ". File will\r\n"
				+ "be renamed as BU, and older BU files will be deleted!");
	}


	
}
