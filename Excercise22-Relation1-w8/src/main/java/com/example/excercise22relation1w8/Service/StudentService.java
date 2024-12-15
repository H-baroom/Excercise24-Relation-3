package com.example.excercise22relation1w8.Service;

import com.example.excercise22relation1w8.Api.ApiException;
import com.example.excercise22relation1w8.DTO.*;
import com.example.excercise22relation1w8.Model.Course;
import com.example.excercise22relation1w8.Model.Student;
import com.example.excercise22relation1w8.Model.Teacher;
import com.example.excercise22relation1w8.Repository.CourseRepository;
import com.example.excercise22relation1w8.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<StudentOutDTO> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        List<StudentOutDTO> studentOutDTOS = new ArrayList<>();

        for (Student student : allStudents) {
            studentOutDTOS.add(new StudentOutDTO(student.getName(),student.getMajor(),getAllCoursesStudents(student.getCourses())));
        }
        return studentOutDTOS;
    }

    public List<CoursesStudentsOutDTO> getAllCoursesStudents(Set<Course> courses) {

        List<CoursesStudentsOutDTO> coursesStudentsOutDTOS = new ArrayList<>();
        for (Course course : courses) {
            coursesStudentsOutDTOS.add(new CoursesStudentsOutDTO(course.getName()));
        }
        return coursesStudentsOutDTOS;
    }

    //public List<CourseOutDTO> convertCourseToCourseOutDTO(List<Course> courses) {
        //List<Course> allCourses = courseRepository.findAll();
        //List<CourseOutDTO> courseOutDTOs = new ArrayList<>();
        //for (Course course : allCourses) {
            //AddressOutDTO addressOutDTO = new AddressOutDTO(course.getTeacher().getAddress().getArea(),course.getTeacher().getAddress().getStreet(),course.getTeacher().getAddress().getBuildingNumber());
            //TeacherOutDTO teacherOutDTO = new TeacherOutDTO(course.getTeacher().getName(), course.getTeacher().getEmail(),addressOutDTO)
            //CourseOutDTO courseOutDTO = new CourseOutDTO(course.getName(),course.getTeacher(),)
        //}
    //}

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id,Student student) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("student not found");
        }
        student.setName(student1.getName());
        student.setMajor(student1.getMajor());
        student.setAge(student1.getAge());
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("student not found");
        }
        studentRepository.delete(student1);
    }

    public void assignStudentToCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentById(studentId);
        Course course = courseRepository.findCourseById(courseId);
        if (student == null || course == null) {
            throw new ApiException("student or course not found");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeMajor(Integer student_id, String major) {
        Student student = studentRepository.findStudentById(student_id);
        if (student == null) {
            throw new ApiException("student not found");
        }
        student.setMajor(major);
        student.setCourses(null);
        studentRepository.save(student);
    }


}
