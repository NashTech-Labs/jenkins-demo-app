package edu.knoldus.model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * test suite for class Student.
 */
public class StudentTest {

  /**
   * Constant value 1.
   */
  private static final int ONE = 1;
  /**
   * Constant value 2.
   */
  private static final int TWO = 2;

  /**
   * genius is a student having some subjects.
   */
  private static Student genius;
  /**
   * misfit is a student having no subjects.
   */
  private static Student misfit;
  /**
   * subject list.
   */
  private static List<String> subjectsBackEnd;

  /**
   *
   */
  @BeforeClass
  public static void setUp() {
    subjectsBackEnd = new ArrayList<>();
    subjectsBackEnd.add("akka");
    subjectsBackEnd.add("scala");
    misfit = new Student("Jeff", TWO, Optional.empty());
    genius = new Student("Einstein", ONE, Optional.of(subjectsBackEnd));
  }

  /**
   * test case to check subjects are added.
   */
  @Test
  public final void testGetSubjects() {
    assertArrayEquals("Student has 2 subjects",
        genius.getSubjects().toArray(),
        subjectsBackEnd.toArray());
  }

  /**
   * test case to check subjects are empty.
   */
  @Test
  public final void testGetSubjectsWithMisfit() {
    assertArrayEquals("Student has 0 subject assigned",
        misfit.getSubjects().toArray(),
        new String[]{});
  }

  /**
   * test case to check the name of student.
   */
  @Test
  public final void testGetName() {
    String expectedResult = "Einstein";
    assertEquals("Every student must have a name",
        genius.getName(),
        expectedResult);
  }

  /**
   * test case to check the roll number.
   */
  @Test
  public final void testGetRollNumber() {
    assertEquals("Student has roll number 1",
        genius.getRollNumber(),
        ONE);
  }

  /**
   * test case to check presence of subject.
   */
  @Test
  public final void testHasSubject() {
    assertEquals("Student has subjects", genius.hasSubjects(), true);
  }

  /**
   * test case to check absence of subject.
   */
  @Test
  public final void testHasSubjectWithJeff() {
    assertEquals("Student doesn't have any subject",
        misfit.hasSubjects(), false);
  }

  /**
   * test case to check for stringify student.
   */
  @Test
  public final void testToString() {
    String expectedResult = "Roll No: " +
        genius.getRollNumber() + "\nName: " + genius.getName();
    assertEquals("Student's roll number and name is displayed",
        genius.toString(),
        expectedResult);
  }
}
