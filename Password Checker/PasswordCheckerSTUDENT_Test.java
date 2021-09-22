
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {

		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("hi12"));
		} catch (LengthException e) {
			assertTrue("Successfully threw a lengthExcepetion", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);
		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("hiheyhi$"));
		} catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaExcepetion", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false);
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("HIHEYHI$"));
		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaExcepetion", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("Hihey5$"));
		} catch (WeakPasswordException e) {
			assertTrue("Successfully threw a WeakPasswordException", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides WeakPasswordException", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("HiiHello5$"));
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides an InvalidSequenceException", false);
		}
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("HiHello!$#$"));
		} catch (NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides a NoDigitException", false);
		}
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("L@k3rzIn5!"));
			assertEquals(true, PasswordCheckerUtility.isValidPassword("CmSc204Pr0ject!"));
			assertEquals(true, PasswordCheckerUtility.isValidPassword("1980T0yOta$iviC"));
		} catch (Exception e) {
			assertTrue("Threw some exception", false);
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {

		ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(true, results.get(0).contains("BROKENWINDOW5"));
		assertEquals(true, results.get(1).contains("brokenwindow5"));
		assertEquals(true, results.get(2).contains("anotherbrokenwindow"));
	}
}
