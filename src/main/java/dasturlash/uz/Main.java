package dasturlash.uz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        insertStudents();
//        simpleForm();
//        fullClassAddress();
//        usingSelect();
//        asClause();
//        whereExample1();
//        whereLikeExample();
//        orderByExample();
//        updateQuery();
//        deleteQuery();
//        insertIntoSelect();
    }

    // example_1
    private static void simpleForm() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "From StudentEntity"; // select * from student
        Query<StudentEntity> query = session.createQuery(sql);
        List<StudentEntity> studentList = query.list();

        for (StudentEntity student : studentList) {
            System.out.println(student);
        }

        factory.close();
        session.close();
    }

    // example_2
    private static void fullClassAddress() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "From dasturlash.uz.StudentEntity";  // select * from student
        Query<StudentEntity> query = session.createQuery(sql);
        List<StudentEntity> studentList = query.list();

        for (StudentEntity student : studentList) {
            System.out.println(student);
        }

        factory.close();
        session.close();
    }

    // example_3
    private static void asClause() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "Select s From StudentEntity s";
        Query query = session.createQuery(sql);
        List<StudentEntity> studentList = query.list();

        factory.close();
        session.close();
    }

    // example_5
    private static void usingSelect() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "SELECT s.id, s.name From StudentEntity as s";
        Query query = session.createQuery(sql);
     /*   List<StudentEntity> studentList = query.list();
        for(StudentEntity student: studentList){
            System.out.println(student);
        }*/
        List<Object[]> studentList = query.list();

        for (Object[] obj : studentList) {
            System.out.println(obj[0] + " " + obj[1]);
        }

        factory.close();
        session.close();
    }

    //example_6
    private static void usingSelectAndAs() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "SELECT s.id, s.name From StudentEntity AS s";
        Query<StudentEntity> query = session.createQuery(sql);
        List<StudentEntity> studentList = query.list();

        for (StudentEntity student : studentList) {
            System.out.println(student);
        }

        factory.close();
        session.close();
    }

    //example_7
    private static void whereExample1() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "From StudentEntity where age > 20";
        Query<StudentEntity> query = session.createQuery(sql);
        List<StudentEntity> studentList = query.list();

        for (StudentEntity student : studentList) {
            System.out.println(student);
        }

        factory.close();
        session.close();
    }

    //example_8
    private static void whereLikeExample() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "From StudentEntity s where lower(s.name) like '%li%' and lower(s.surname) like '%ev%' ";
        Query<StudentEntity> query = session.createQuery(sql);
        List<StudentEntity> studentList = query.list();

        for (StudentEntity student : studentList) {
            System.out.println(student);
        }

        factory.close();
        session.close();
    }

    //example_9
    private static void orderByExample() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "From StudentEntity s where s.name = 'Ali' order by s.age desc";
        Query<StudentEntity> query = session.createQuery(sql);
        List<StudentEntity> studentList = query.list();

        for (StudentEntity student : studentList) {
            System.out.println(student);
        }

        factory.close();
        session.close();
    }

    //example_10
    private static void orderBySeveralItemsExample() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "From StudentEntity s where s.name = 'Ali' order by s.age desc, s.groupName asc ";
        Query<StudentEntity> query = session.createQuery(sql);
        List<StudentEntity> studentList = query.list();

        for (StudentEntity student : studentList) {
            System.out.println(student);
        }

        factory.close();
        session.close();
    }

    //example_11
    private static void namedParameterExample(Integer studentId) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String sql = "From StudentEntity s where s.id =:studentId";
        Query<StudentEntity> query = session.createQuery(sql);
        query.setParameter("studentId", studentId);
        List<StudentEntity> studentList = query.list();

        for (StudentEntity student : studentList) {
            System.out.println(student);
        }

        factory.close();
        session.close();
    }

    //example_12
    private static void updateQuery() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String sql = "Update StudentEntity s set s.name=:studentName, s.surname =:studentSurname where s.id =:studentId";
        Query query = session.createQuery(sql);
        query.setParameter("studentName", "Mazgi");
        query.setParameter("studentSurname", "Mazgiyev");
        query.setParameter("studentId", 1);

        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);

        t.commit();
        factory.close();
        session.close();
    }

    //example_13
    private static void deleteQuery() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String sql = "Delete StudentEntity s where s.id =:studentId ";
        Query query = session.createQuery(sql);
        query.setParameter("studentId", 1);

        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);

        t.commit();
        factory.close();
        session.close();
    }

    private static void insertIntoSelect() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String sql = "insert into BettaGroupStudent (name,surname) " +
                " Select name, surname from StudentEntity where groupName = 'betta'";
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);

        t.commit();
        factory.close();
        session.close();
    }

    public static void insertStudents() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        StudentEntity student1 = new StudentEntity();
        student1.setName("Ali");
        student1.setSurname("Aliyev");
        student1.setAge(22);
        student1.setGroupName("alfa");
        session.save(student1);

        StudentEntity student2 = new StudentEntity();
        student2.setName("Vali");
        student2.setSurname("Valiyev");
        student2.setAge(24);
        student2.setGroupName("betta");
        session.save(student2);

        StudentEntity student3 = new StudentEntity();
        student3.setName("Toshmat");
        student3.setSurname("Toshmatov");
        student3.setAge(19);
        student3.setGroupName("delta");
        session.save(student3);

        StudentEntity student4 = new StudentEntity();
        student4.setName("Eshmat");
        student4.setSurname("Eshmatov");
        student4.setAge(28);
        student4.setGroupName("Mazgi");
        session.save(student4);

        t.commit();

        factory.close();
        session.close();
    }
}