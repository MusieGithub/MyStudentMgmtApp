package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Double cgpa;
    private LocalDate dateOfEnrollment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="classroom_Id", nullable = true)
    private Classroom classroom;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="transcript_Id", nullable = true)
    private Transcript transcript;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Students_Courses",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "courseId")}
    )
    private List<Course> courses;


//    public Student(Long studentId, String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment) {
//        this.studentId = studentId;
//        this.studentNumber = studentNumber;
//        this.firstName = firstName;
//        this.middleName=middleName;
//        this.lastName = lastName;
//        this.cgpa = cgpa;
//        this.dateOfEnrollment = dateOfEnrollment;
//    }
    public Student() {

    }
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public List<Course> getCourse() {
        return courses;
    }

    public void setCourse(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", classroom=" + classroom +
                ", transcript=" + transcript +
                ", courses=" + courses+
                '}';
    }
}
