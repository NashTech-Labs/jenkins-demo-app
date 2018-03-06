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
public class StudentTester {

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
   *
   */
  @Test
  public final void testGetSubjects() {
    assertArrayEquals("Student has 2 subjects",
        genius.getSubjects().toArray(),
        subjectsBackEnd.toArray());
  }

  /**
   *
   */
  @Test
  public final void testGetSubjectsWithMisfit() {
    assertArrayEquals("Student has 0 subject assigned",
        misfit.getSubjects().toArray(),
        new String[]{});
  }

  /**
   *
   */
  @Test
  public final void testGetName() {
    String expectedResult = "Einstein";
    assertEquals("Every student must have a name",
        genius.getName(),
        expectedResult);
  }

  /**
   *
   */
  @Test
  public final void testGetRollNumber() {
    assertEquals("Student has roll number 1",
        genius.getRollNumber(),
        ONE);
  }

  /**
   *
   */
  @Test
  public final void testHasSubject() {
    assertEquals("Student has subjects", genius.hasSubjects(), true);
  }

  /**
   *
   */
  @Test
  public final void testHasSubjectWithJeff() {
    assertEquals("Student doesn't have any subject",
        misfit.hasSubjects(), false);
  }

}
