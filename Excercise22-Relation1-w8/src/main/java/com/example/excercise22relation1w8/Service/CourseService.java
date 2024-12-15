package com.example.excercise22relation1w8.Service;

import com.example.excercise22relation1w8.Api.ApiException;
import com.example.excercise22relation1w8.DTO.*;
import com.example.excercise22relation1w8.Model.Address;
import com.example.excercise22relation1w8.Model.Course;
import com.example.excercise22relation1w8.Model.Student;
import com.example.excercise22relation1w8.Model.Teacher;
import com.example.excercise22relation1w8.Repository.CourseRepository;
import com.example.excercise22relation1w8.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<CourseOutDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseOutDTO> courseOutDTOs = new ArrayList<>();
        for (Course course : courses) {
            CourseOutDTO courseOutDTO = new CourseOutDTO(course.getName(),convertTeacherToTeacherOutDTO(course.getTeacher()),course.getStudents());
            courseOutDTOs.add(courseOutDTO);
        }
        return courseOutDTOs;
    }

    public TeacherOutDTO convertTeacherToTeacherOutDTO(Teacher teacher) {
        Address address = teacher.getAddress();
        AddressOutDTO addressOutDTO = new AddressOutDTO(address.getArea(),address.getStreet(),address.getBuildingNumber());
        TeacherOutDTO teacherOutDTO = new TeacherOutDTO(teacher.getName(),teacher.getEmail(),addressOutDTO);

        return teacherOutDTO;
    }


    public List<StudentOutDTO> convertStudentToStudentOutDTO(List<Student> students) {
        List<StudentOutDTO> studentOutDTOs = new ArrayList<>();
        for (Student student : students) {
            //StudentOutDTO studentOutDTO = new StudentOutDTO(student.getName(),)
        }
        return studentOutDTOs;
    }

    public void addCourse(Integer teacher_id, Course course) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void updateCourse(Integer course_id, Course course) {
        Course course1 = courseRepository.findCourseById(course_id);
        if (course1 == null) {
            throw new ApiException("Course not found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);
    }

    public void deleteCourse(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        if (course.getTeacher() != null) {
            course.setTeacher(null);
            courseRepository.save(course);
        }
        courseRepository.delete(course);
    }

    public String teacherNameByCourse(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        Teacher teacher = course.getTeacher();
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher.getName();
    }

    public List<StudentCourseOutDTO> getAllStudentByCourseId(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        Set<Student> students = course.getStudents();
        List<StudentCourseOutDTO> studentCourseOutDTOs = new ArrayList<>();
        for (Student s:students){
            StudentCourseOutDTO studentCourseOutDTO = new StudentCourseOutDTO(s.getName(),s.getMajor());
            studentCourseOutDTOs.add(studentCourseOutDTO);
        }
        return studentCourseOutDTOs;
    }
}
