// -----------------------------------------------------
// Assignment 3
// Written by: Yaroslav Bilodid ID#40068605
// -----------------------------------------------------

/**
 * Yaroslav Bilodid ID#40068605
 * COMP249
 * Assignment # 3
 * Due Date 21-03-2019
 * The Class Article for found articles
 */
public class Article {
	
	/** The author. */
	protected String author;
	
	/** The journal. */
	protected String journal;
	
	/** The title. */
	protected String title;
	
	/** The year. */
	protected String year;
	
	/** The volume. */
	protected String volume;
	
	/** The number. */
	protected String number;
	
	/** The pages. */
	protected String pages;
	
	/** The keywords. */
	protected String keywords;
	
	/** The DOI. */
	protected String doi;
	
	/** The ISSN. */
	protected String ISSN;
	
	/** The month. */
	protected String month;

	/**
	 * Parametized constructor
	 *
	 * @param info the  array of information about article
	 */
	public Article(String[] info) {
		super();
		this.author = info[0];
		this.journal = info[1];
		this.title = info[2];
		this.year = info[3];
		this.volume = info[4];
		this.pages = info[5];
		this.keywords = info[6];
		this.doi = info[7];
		ISSN = info[8];
		this.month = info[9];
		this.number = info[10];
	}


	/**
	 * Generates IEEE record.
	 *
	 * @return the string which contains IEEE record
	 */
	public String generateIEEE() {
		return this.author.replaceAll(" and", ",") + ". \"" + this.title + "\", " + this.journal + ", vol. "
				+ this.volume + ", p. " + this.pages + ", " + this.month + " " + this.year + ".";
	}

	/**
	 * Generates NJ record.
	 *
	 * @return the string which contains NJ record
	 */
	public String generateNJ() {
		return this.author.replaceAll("and", "&") + ". " + this.title + ". " + this.journal + ". " + this.volume + ", "
				+ this.pages + "(" + this.year + ").";
	}

	/**
	 * Generates ACM record.
	 *
	 * @param count the count of found articles
	 * @return the string which contains ACM record
	 */
	public String generateACM(int count) {
		return "[" + count + "]" + '\t' + this.author.replaceAll("and(\\D)*", " et al. ") + this.year + ". "
				+ this.title + ". " + this.journal + ". " + this.volume + ", " + this.number + " (" + this.year + "), "
				+ this.pages + ".  DOI:https://doi.org/" + this.doi + ".";
	}
}
