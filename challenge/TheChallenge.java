package challenge;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;
import java.util.Vector;

import challenge.Challenge;
import challenge.GenAlgo;

/**
 * The Class TheChallenge.
 * <p>
 * This class is the "manager of the tournament". It loads the classes and
 * arranges the duel between the players. More details see
 * {@link TheChallenge#main(String[])}.
 * </p>
 * <p>
 * To simulate the duels, the class {@link Challenge} is used.
 * <p>
 *
 * @see TheChallenge#main(String[])
 * @see Challenge
 *
 * @author D. Z.
 * @version 00.01.003
 */
public class TheChallenge {

	/**
	 * The Constant STARTTAGGEN. Define the Prefix the class musst have to be
	 * loaded at runtime
	 */
	private static final String STARTTAGGEN = "GenAlgo_";

	/**
	 * The Constant STARTTAGFIX. Define the Prefix of the fixed GenAlgo (fixed
	 * Strategie) to be loaded at runtime
	 */
	private static final String STARTTAGFIX = "Fix_";

	/**
	 * The Constant PACKATGE. Defines the main package in which the programm
	 * turns
	 */
	private static final String PACKATGE = "challenge";

	// ---------------------------------------------------------------------------

	/**
	 * The main method.
	 *<p>
	 * This is the main method, which loads all implementations of
	 * {@link GenAlgo} interface with the prefix defined in the
	 * {@link TheChallenge#STARTTAGGEN} in the packages defined in the Constant
	 * {@link TheChallenge#PACKATGE} and lets play them against each other. Also
	 * a fixed strategy (which is also an implementation of {@link GenAlgo} with
	 * prefix defined in {@link TheChallenge#STARTTAGFIX}) will be loaded and
	 * played against the other {@link GenAlgo} implementations.
	 *</p>
	 *<p>
	 * The default values are (Attention, can easily be changed be any one,
	 * control Content of Constants):
	 * <ul>
	 * <li>for the {@link GenAlgo} classes implemented by players: "GenAlgo_"</li>
	 * <li>for the {@link GenAlgo} with fixed strategy : "Fix_"</li>
	 * <li>for the package, this package, who should be: "challenge"</li>
	 * </ul>
	 *</p>
	 *<p>
	 * That the Play works, every implementation of the {@link GenAlgo} from
	 * every team must be in the correct Packages (See above). If more classes
	 * are needed, they must be placed in the sub-packages of the main packages
	 * with the Team name. Example with the standard values and "team 1":
	 * <ul>
	 * <li><b>challenge</b> : Contains the main classes and GenAlgo_Team1.java
	 * (implementation of {@link GenAlgo})
	 * <li><b>challenge.<i>team1</i></b> : Contains all other classes, that team
	 * 1 needs for their implementation
	 * </ul>
	 *</p>
	 *
	 * @param args
	 *            the arguments - put are not used in this main
	 */
	public static void main(String[] args) {
		Vector<String> classes_gen = new Vector<String>();
		Vector<String> classes_fix = new Vector<String>();
		Random rnd = new Random();
		boolean startH[][] = new boolean[Challenge.HISTORY][Challenge.NRMEMBERS];

		int montJail[];
		int montJailFix[];

		GenAlgo firstDuealant;
		GenAlgo secondDuealant;

		// ---- Load Classes ----
		classes_gen = getClasses(PACKATGE, STARTTAGGEN);
		montJail = new int[classes_gen.size()];
		montJailFix = new int[classes_gen.size()];

		classes_fix = getClasses(PACKATGE, STARTTAGFIX);

		// ---- Random Start History ----
		for (int i = 0; i < Challenge.HISTORY; i++) {
			boolean tmp = rnd.nextBoolean();
			startH[i][0] = tmp;

			tmp = rnd.nextBoolean();
			startH[i][1] = tmp;
		}

		// ---- Duels each With Fixed Strategy ----
		for (int i = 0; i < classes_gen.size(); i++) {
			for (int j = 0; j < classes_fix.size(); j++) {
				try {
					firstDuealant = (GenAlgo) Class.forName(
							PACKATGE + "." + classes_gen.elementAt(i))
							.newInstance();
					secondDuealant = (GenAlgo) Class.forName(
							PACKATGE + "." + classes_fix.elementAt(j))
							.newInstance();

					int result[] = Challenge.duel(startH, firstDuealant,
							secondDuealant, false);

					montJailFix[i] += result[0];

				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				try {
					firstDuealant = (GenAlgo) Class.forName(
							PACKATGE + "." + classes_gen.elementAt(i))
							.newInstance();
					secondDuealant = (GenAlgo) Class.forName(
							PACKATGE + "." + classes_fix.elementAt(j))
							.newInstance();

					int result[] = Challenge.duel(startH, secondDuealant,
							firstDuealant, false);

					montJailFix[i] += result[1];

				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

		// ---- Duels each team against all others ----
		for (int i = 0; i < classes_gen.size(); i++) {
			for (int j = i + 1; j < classes_gen.size(); j++) {
				try {
					firstDuealant = (GenAlgo) Class.forName(
							PACKATGE + "." + classes_gen.elementAt(i))
							.newInstance();
					secondDuealant = (GenAlgo) Class.forName(
							PACKATGE + "." + classes_gen.elementAt(j))
							.newInstance();

					int result[] = Challenge.duel(startH, firstDuealant,
							secondDuealant, false);

					montJail[i] += result[0];
					montJail[j] += result[1];

				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				try {
					firstDuealant = (GenAlgo) Class.forName(
							PACKATGE + "." + classes_gen.elementAt(i))
							.newInstance();
					secondDuealant = (GenAlgo) Class.forName(
							PACKATGE + "." + classes_gen.elementAt(j))
							.newInstance();

					int result[] = Challenge.duel(startH, secondDuealant,
							firstDuealant, false);

					montJail[j] += result[0];
					montJail[i] += result[1];

				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

		System.out
				.println("\n\n=============== The result are : ===============");
		System.out.println("\n *** Against the Fixed Strategy *** ");
		System.out.println("Group Name    -       total Months in Jail");
		System.out.println("-----------------------------------------");
		for (int i = 0; i < classes_gen.size(); i++) {
			try {
				firstDuealant = (GenAlgo) Class.forName(
						PACKATGE + "." + classes_gen.elementAt(i))
						.newInstance();

				System.out.println(firstDuealant.getGroupName() + "\t - \t"
						+ montJailFix[i]);

			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\n\n *** Team against Team *** ");
		System.out.println("Group Name    -       total Months in Jail");
		System.out.println("-----------------------------------------");
		for (int i = 0; i < classes_gen.size(); i++) {
			try {
				firstDuealant = (GenAlgo) Class.forName(
						PACKATGE + "." + classes_gen.elementAt(i))
						.newInstance();

				System.out.println(firstDuealant.getGroupName() + "\t - \t"
						+ montJail[i]);

			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	// ---------------------------------------------------------------------------

	/**
	 * Gets the classes.
	 *
	 * @param pckgname
	 *            the package name to search classes
	 * @param classePrefixe
	 *            the class prefix to load
	 * @return the classes with the prefix given in the package given as param.
	 */
	public static Vector<String> getClasses(String pckgname,
			String classePrefixe) {
		// Création de la liste qui sera retournée
		Vector<String> classes = new Vector<String>();

		try {
			// On récupère toutes les entrées du CLASSPATH
			String[] entries = System.getProperty("java.class.path").split(
					System.getProperty("path.separator"));

			for (String entry : entries) {
				classes.addAll(traitementRepertoire(entry, pckgname));
			}
			int i = 0;
			while (i < classes.size()) {
				String classe = (String) classes.get(i);
				if (classe.startsWith(classePrefixe)) {
					i++;
				} else {
					classes.remove(classe);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return classes;
	}

	// ---------------------------------------------------------------------------

	private static Vector<String> traitementRepertoire(String repertoire,
			String pckgname) throws ClassNotFoundException {
		Vector<String> classes = new Vector<String>();

		// On génère le chemin absolu du package
		StringBuffer sb = new StringBuffer(repertoire);
		String[] repsPkg = pckgname.split("\\.");
		for (int i = 0; i < repsPkg.length; i++) {
			sb.append(System.getProperty("file.separator") + repsPkg[i]);
		}
		File rep = new File(sb.toString());

		// Si le chemin existe, et que c'est un dossier, alors, on le liste
		if (rep.exists() && rep.isDirectory()) {
			// On filtre les entrées du répertoire
			FilenameFilter filter = new DotClassFilter();
			File[] liste = rep.listFiles(filter);

			// Pour chaque classe présente dans le package, on l'ajoute à la
			// liste
			for (int i = 0; i < liste.length; i++) {
				classes.add(Class.forName(
						pckgname + "." + liste[i].getName().split("\\.")[0])
						.getSimpleName());
			}
		}

		return classes;
	}

	// ---------------------------------------------------------------------------

	private static class DotClassFilter implements FilenameFilter {
		public boolean accept(File arg0, String arg1) {
			return arg1.endsWith(".class");
		}
	}
}
