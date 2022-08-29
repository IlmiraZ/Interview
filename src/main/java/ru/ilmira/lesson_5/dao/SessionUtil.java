package ru.ilmira.lesson_5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.function.Consumer;
import java.util.function.Function;

public interface SessionUtil {
    default  <T> T execute(SessionFactory sessionFactory, Function<Session, T> function) {
        try (Session sf = sessionFactory.openSession()) {
            return function.apply(sf);
        }
    }

    default void executeInTransaction(SessionFactory sessionFactory, Consumer<Session> consumer) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            consumer.accept(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
