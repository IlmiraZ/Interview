package ru.ilmira.lesson_5.demo;

import org.hibernate.SessionFactory;
import ru.ilmira.lesson_5.dao.StudentDao;
import ru.ilmira.lesson_5.dao.StudentDaoImpl;
import ru.ilmira.lesson_5.entity.Student;
import ru.ilmira.lesson_5.utils.HibUtil;

import java.util.List;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibUtil.getSessionFactory();
        StudentDao<Student> studentDao = new StudentDaoImpl(sessionFactory);

        // -save-
        System.out.println("save student: ");
        System.out.println("---------------------------");
        Student student = new Student("Student1001", 5);
        studentDao.save(student);
        System.out.println();

        // -findById-
        System.out.println("find a student by id: ");
        System.out.println("---------------------------");
        long id = 9L;
        Optional<Student> product = studentDao.findById(id);
        product.ifPresentOrElse(System.out::println, () -> System.out.println("student with id = " + id + " not found.")
        );
        System.out.println();

        // -findAll-
        System.out.println("find all student: ");
        System.out.println("---------------------------");
        List<Student> students = studentDao.findAll();
        System.out.println(students);
        System.out.println();

        // -delete-
        System.out.println("delete student: ");
        System.out.println("---------------------------");
        studentDao.deleteById(7L);
        students = studentDao.findAll();
        System.out.println(students);

        sessionFactory.close();
    }
}
