package ru.ilmira.lesson_5.dao;

import org.hibernate.SessionFactory;
import ru.ilmira.lesson_5.entity.Student;

import java.util.List;
import java.util.Optional;


public class StudentDaoImpl implements StudentDao<Student>, SessionUtil {
    private final SessionFactory sessionFactory;

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Student> findById(long id) {
        return execute(sessionFactory,
                sf -> Optional.ofNullable(sf.find(Student.class, id))
        );

    }

    @Override
    public List<Student> findAll() {
        return execute(sessionFactory,
                sf -> sf.createQuery("from Student s", Student.class)
                        .getResultList()
        );
    }

    @Override
    public void save(Student student) {
        executeInTransaction(sessionFactory, sf -> {
            if (student.getId() == null) {
                sf.persist(student);
            } else {
                sf.merge(student);
            }
        });
    }

    @Override
    public void update(Student student) {
        executeInTransaction(sessionFactory, sf -> {
            if (student.getId() != null) {
                sf.merge(student);
            }
        });
    }

    @Override
    public void deleteById(long id) {
        executeInTransaction(sessionFactory,
                sf -> sf.createQuery("delete from Student where id = :id")
                        .setParameter("id", id)
                        .executeUpdate()
        );
    }

    @Override
    public void deleteAll() {
        executeInTransaction(sessionFactory, sf -> {
                    sf.createNativeQuery("delete from students", Student.class)
                            .executeUpdate();
                    sf.flush();
                }
        );
    }
}
