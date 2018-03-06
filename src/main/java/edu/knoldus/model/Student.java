package edu.knoldus.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Student: implementation of a real world entity.
 */
public class Student {

  /**
   * name: stands for the name of the student.
   */
  private String name;
  /**
   * rollNumber: stands for the enrollment number of the student.
   */
  private int rollNumber;
  /**
   * subjects: stands for all the subjects a students is currently studying.
   */
  private Optional<List<String>> subjects;

  /**
   * @param studentName      : Name of the student
   * @param enrollmentNumber : roll number of the student
   * @param providedSubjects : list of subjects can also be null
   */
  Student(final String studentName, final int enrollmentNumber,
          final Optional<List<String>> providedSubjects) {
    this.name = studentName;
    this.rollNumber = enrollmentNumber;
    this.subjects = providedSubjects;
  }

  /**
   * @return : get List of subjects
   */
  public final List<String> getSubjects() {
    return this.subjects.orElseGet(ArrayList::new);
  }

  /**
   * @return : get Name
   */
  public final String getName() {
    return this.name;
  }

  /**
   * @return : get rollNumber
   */
  public final int getRollNumber() {
    return this.rollNumber;
  }

  /**
   * @return : true if there are subjects present
   */
  public final boolean hasSubjects() {
    return this.subjects.isPresent();
  }


  @Override
  public final String toString() {
    return "Roll No: " + this.rollNumber + "\nName: " + this.name;
  }
}
