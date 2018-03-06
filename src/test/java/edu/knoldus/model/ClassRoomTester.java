package edu.knoldus.model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * test suite for testing ClassRoom class.
 */
public class ClassRoomTester {

  /**
   * Constant value 1.
   */
  private static final int ONE = 1;
  /**
   * Constant value 2.
   */
  private static final int TWO = 2;
  /**
   * Constant value 3.
   */
  private static final int THREE = 3;
  /**
   * Constant value 4.
   */
  private static final int FOUR = 4;

  /**
   * room, instance of ClassRoom,  has some students.
   */
  private static ClassRoom room;
  /**
   * storeRoom, instance of ClassRoom, has no students.
   */
  private static ClassRoom storeRoom;
  /**
   * List of student instances.
   * to be later added to a room.
   */
  private static List<Student> students;

  /**
   * Sets up the instances and associates subjects.
   */
  @BeforeClass
  public static void setUp() {
    List<String> subjectsBackEnd = new ArrayList<>();
    subjectsBackEnd.add("akka");
    subjectsBackEnd.add("scala");

    List<String> subjectsFrontEnd = new ArrayList<>();
    subjectsFrontEnd.add("html");
    subjectsFrontEnd.add("angular 2");
    students = new ArrayList<>();
    students.add(new Student("Vinay", ONE, Optional.empty()));
    students.add(new Student("Akash", TWO, Optional.of(subjectsBackEnd)));
    students.add(new Student("Ravish", THREE, Optional.of(subjectsFrontEnd)));
    students.add(new Student("EKta", FOUR, Optional.of(subjectsBackEnd)));
    room = new ClassRoom(1, Optional.of(students));
    storeRoom = new ClassRoom(2, Optional.empty());
  }

  /**
   * tests Room number of a room.
   */
  @Test
  public final void testGetRoomId() {
    int actualResult = room.getRoomId();
    int expectedResult = 1;
    assertEquals("Getting a room id must result in 1",
        expectedResult, actualResult);
  }

  /**
   * checks whether the room has students or not.
   */
  @Test
  public final void testGetStudents() {
    assertEquals("Room must have students",
        room.hasStudents(), true);
  }

  /**
   * checks whether the store room has students or not.
   */
  @Test
  public final void testGetStudentsStore() {
    assertEquals("Store Room must not have students",
        storeRoom.hasStudents(), false);
  }

  /**
   * checks students with no subjects.
   */
  @Test
  public final void testGetStudentsWithNoSubject() {
    Stream<Student> expectedResult =
        students.stream().filter(student -> !student.hasSubjects());
    assertArrayEquals("Room 1 has Only one student with no subjects",
        room.getStudentsWithNoSubjects().toArray(), expectedResult.toArray());
  }

  /**
   * checks students with no subjects in store room.
   */
  @Test
  public final void testGetStudentsWithNoSubjectForStore() {
    assertArrayEquals("Store Room has no students",
        storeRoom.getStudentsWithNoSubjects().toArray(), new Student[]{});
  }

  /**
   * checks if to see if the room greets students.
   */
  @Test
  public final void testGreetStudent() {
    String expectedResult = "Room: " + room.getRoomId() + " Hello Students!";
    assertEquals("Room has students so they will be greeted",
        room.greetStudents(), expectedResult);
  }

  /**
   * checks to see if store room greets the students.
   */
  @Test
  public final void testGreetStudentInStoreRoom() {
    String expectedResult = "Room: " + storeRoom.getRoomId() + "";
    assertEquals("Store room has no one,  so no greetings",
        storeRoom.greetStudents(), expectedResult);
  }

  /**
   * checks whether the subjects.
   */
  @Test
  public final void testGetStudentSubjects() {
    Stream<String> expectedSubjects = students.stream()
        .map(Student::getSubjects)
        .flatMap(Collection::stream);

    assertArrayEquals("Returns all the subjects",
        room.getStudentsSubject().toArray(),
        expectedSubjects.toArray());
  }

}
