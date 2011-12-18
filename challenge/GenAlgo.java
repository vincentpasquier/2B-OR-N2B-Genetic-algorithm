package challenge;

/**
 * The Interface GenAlgo.
 * <p>
 * Interface for Genetic Algorithm. With this interface, the class
 * {@link Challenge} and {@link TheChallenge} are able to do the simulation and
 * "battle" between different Algorithms of this Classes.
 * </p>
 * <p>
 * Annotation: for the Constructor, it needs an empty constructor !
 * </p>
 * 
 * @author D. Z.
 * @version 00.01.003
 */
public interface GenAlgo {

	/** The Constant BETRAY. */
	static final boolean BETRAY = true;

	/**
	 * The Constant B. Means to betray (like {@link GenAlgo#BETRAY})
	 */
	static final boolean B = true;

	/** The Constant NOT_BETRAY. */
	static final boolean NOT_BETRAY = false;

	/**
	 * The Constant N. Means to not betray (like {@link GenAlgo#NOT_BETRAY})
	 */
	static final boolean N = false;

	/*
	 * ========================================================================
	 * // CONSTRUCTOR: // Make an empty constructor
	 * ==============================
	 * ============================================
	 */

	// input a Array of length 3 Columns (first [], position 0 oldest, position
	// 2 latest choice )
	// with Rows with content last "Games" of Length 2.
	// --> Row Position 0: Your Decision
	// --> Row Position 1: Decision of "Enemy"
	/**
	 * Decision.
	 * <p>
	 * This is the method, which returns, based on the history given as
	 * parameter, the decision to make. The decision is to betray or not betray.
	 * The return values are predefined in the constants {@link GenAlgo#BETRAY}
	 * and {@link GenAlgo#NOT_BETRAY}.
	 * </p>
	 * <p>
	 * The Input format for the History is an Array of the Format [
	 * {@link Challenge#HISTORY}][2]. The First Row is your (the implementation
	 * of your class) decisions History. The second row that of your opponent.
	 * The time-line goes from Up (Position 0) which is the oldest decision, to
	 * Down (Position {@link Challenge#HISTORY}) which is the newest decision.
	 * </p>
	 * 
	 * <p>
	 * The history schematic representation:<br />
	 * <table border="1">
	 * <tr>
	 * <td><font color="red">History[{@link Challenge#HISTORY}][2]</font></td>
	 * <td></td>
	 * <td>your decision [0]</td>
	 * <td>enemy decision [1]</td>
	 * <tr>
	 * <tr>
	 * <td>Oldest decision [0]
	 * <td>
	 * <td align="center">B or N</td>
	 * <td align="center">B or N</td>
	 * </tr>
	 * <tr>
	 * <td>...
	 * <td>
	 * <td align="center">...</td>
	 * <td align="center">...</td>
	 * </tr>
	 * <tr>
	 * <td>Newest decision [{@link Challenge#HISTORY}]
	 * <td>
	 * <td align="center">B or N</td>
	 * <td align="center">B or N</td>
	 * </tr>
	 * </table>
	 * </p>
	 * 
	 * @param history
	 *            the history of the last n rounds (n =
	 *            {@link Challenge#HISTORY})
	 * @return true when the GenAlgo betrays (see {@link GenAlgo#BETRAY}, false
	 *         when the GenAlgo does not betray (see {@link GenAlgo#NOT_BETRAY})
	 */
	public boolean decision(boolean history[][]);

	/**
	 * Gets the group name.
	 * 
	 * @return the group name
	 */
	public String getGroupName();
}
