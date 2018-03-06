package edu.knoldus.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * ClassRoom: Class representation of a class room.
 * consist of room number and list of students entering
 * that class room
 */
public class ClassRoom {

  /**
   * roomId : stands for the number of the room.
   */
  private int roomId;
  /**
   * studentList: stands for the students belonging to a room.
   */
  private Optional<List<Student>> studentList;

  /**
   * @param roomNumber          : Room number, can only be int
   * @param externalStudentList : List of students belonging to that room
   */
  ClassRoom(final int roomNumber,
            final Optional<List<Student>> externalStudentList) {
    this.roomId = roomNumber;
    this.studentList = externalStudentList;
  }

  /**
   * returns the room number.
   *
   * @return : room number of the class.
   */
  public final int getRoomId() {
    return this.roomId;
  }

  /**
   * @return : returns true if students are present.
   */
  public final boolean hasStudents() {
    return this.studentList.isPresent();
  }

  /**
   * getter for student list.
   *
   * @return : List<Student> is returned.
   */
  private List<Student> getStudentList() {
    return this.studentList.orElseGet(ArrayList::new);
  }

  /**
   * @return : returns list of students with no subjects
   */
  public final Stream<Student> getStudentsWithNoSubjects() {
    if (this.studentList.isPresent()) {
      return this.studentList.get().stream()
          .filter(student -> !student.hasSubjects());
    } else {
      return new ArrayList<Student>().stream();
    }

  }

  /**
   * Return a greeting message, if students are available.
   *
   * @return : Empty , if there are no students in the room
   */
  public final String greetStudents() {
    if (this.studentList.isPresent()) {
      return "Room: " + this.roomId + " Hello Students!";
    } else {
      return "Room: " + this.roomId + "";
    }
  }

  /**
   * @return : returns the subjects taught in this room
   */
  public final Stream<String> getStudentsSubject() {
    return (
        this.getStudentList().stream()
            .map(Student::getSubjects)
            .flatMap(Collection::stream)
    );

  }

}
