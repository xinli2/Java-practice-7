import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Drill07 {

	/*
	 * Takes in a string of the HTML source for a webPage.
	 * Returns a Set<String> containing all of the valid wiki link
	 * titles found in the HTML source.
	 * 
	 * In order for a link to be a valid wikiLink for our case, it must
	 * match the pattern:
	 * <a href="/wiki/Marine_mammal">
	 * and NOT contain the character '#' nor ':'. From the above match, you
	 * would then extract the link name which in this case is:
	 * Marine_mammal
	 * Refer to the testcases for more examples.
	 * 
	 * The fact that the input to this parameter is HTML is largely
	 * irrelevant to this function. It is just a string processing function.
	 * You take in a string, and need to search for matches to a specific
	 * pattern in that string. We will go through a brief description of HTML
	 * in class this week if you are curious.
	 * 
	 * Your first job is to pass all of the tests. This means you either have
	 * a functionally correct algorithm, or are close to one. However, performance
	 * and efficiency will be very important for this PA. After finding a functionally
	 * correct algorithm, spend time designing other approaches to see if
	 * you can determine a more efficient approach. It will pay off when
	 * writing the PA! i.e. do not do anything inefficient, for
	 * instance, you should only go through the string once.
	 */
	public static Set<String> findWikiLinks(String html) {
		Set<String> result = new HashSet<String>();
		String regex = "<a href=\"/wiki/(.*?)\">";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			String name = matcher.group(1);
			if (name.contains(Character.toString('"'))) {
				int end = name.indexOf('"');
				name = name.substring(0, end);
			}
			if (!(name.contains(":") || name.contains("#"))) {
				result.add(name);
			}
		}
		return result;
	}

}
