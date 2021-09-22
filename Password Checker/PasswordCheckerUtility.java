import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {

	public static void comparePasswords(String passwordString, String passwordConfirm) {
		if (passwordString.compareTo(passwordConfirm) != 0)
			throw new UnmatchedException();

	}

	public static boolean comparePasswordsWithReturn(String passwordString, String passwordConfirm) {
		if (passwordString.compareTo(passwordConfirm) == 0)
			return true;
		else
			return false;
	}

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwordString) {

		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String s : passwordString) {
			try {
				isValidPassword(s);
			} catch (Exception ex) {
				invalidPasswords.add(s + " " + ex.getMessage());
			}
		}
		return invalidPasswords;
	}

	public static boolean hasBetweenSixAndNineChars(String passwordString) {
		if (passwordString.length() >= 6 && passwordString.length() <= 9)
			return true;
		else
			return false;
	}

	public static boolean hasDigit(String passwordString) {
		for (Character c : passwordString.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		throw new NoDigitException();
	}

	public static boolean hasLowerAlpha(String passwordString) {
		for (Character c : passwordString.toCharArray()) {
			if (Character.isLowerCase(c)) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}

	public static boolean hasSameCharInSequence(String passwordString) {
		for (int i = 0; i < passwordString.length() - 2; i++) {
			if (passwordString.charAt(i) == passwordString.charAt(i + 1)) {
				if (passwordString.charAt(i + 1) == passwordString.charAt(i + 2)) {
					throw new InvalidSequenceException();
				}
			}
		}
		return true;
	}

	public static boolean hasSpecialChar(String passwordString) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher matcher = pattern.matcher(passwordString);
		if (!matcher.find()) {
			throw new NoSpecialCharacterException();
		}
		return true;
	}

	public static boolean hasUpperAlpha(String passwordString) {
		for (Character c : passwordString.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}

	public static boolean isValidLength(String passwordString) {
		if (passwordString.length() >= 6) {
			return true;
		} else {
			throw new LengthException();
		}
	}

	public static boolean isValidPassword(String passwordString) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		return isValidLength(passwordString) && hasUpperAlpha(passwordString) && hasLowerAlpha(passwordString)
				&& hasDigit(passwordString) && hasSpecialChar(passwordString) && hasSameCharInSequence(passwordString);
	}

	public static boolean isWeakPassword(String passwordString) {
		return isValidPassword(passwordString) && (passwordString.length() < 10);
	}

}
