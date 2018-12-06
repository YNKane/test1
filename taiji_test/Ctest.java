package taiji.taiji_test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.demo.Car;
import com.example.demo.LicensePlate;

public class Ctest {
	EntityManagerFactory factory;
    EntityManager entityManager;
    EntityTransaction transaction;
    @Before
    public void initEntityManagerFactory(){
        // 1. 创建EntityManagerFactory
        factory = Persistence.createEntityManagerFactory("jpa");
        // 2. 创建EntityManager
        entityManager = factory.createEntityManager();
        // 3.开启事务
        transaction = entityManager.getTransaction();

    }
    //增加
    @Test
    public void savePeopleTest(){
        // 3.开启事务
        transaction.begin();
       Car car = new Car();
       car.setManufacturer("bwm");
       car.setColor("red");
       LicensePlate licensePlate = new LicensePlate();
       licensePlate.setLicensePlateNumber("C444444");
       car.setLicensePlateID(licensePlate);
       entityManager.persist(car);
        // 5. 提交事务
        transaction.commit();
    }
    //查找
    @Test
    public void findOnePeopleTest(){
        // 3.开启事务
        transaction.begin();
        Car car = entityManager.find(Car.class,1);
        System.out.println(car);
        // 5. 提交事务
        transaction.commit();
    }
    //删除
   @Test
   public void deletePeopleTest(){
        // 3.开启事务
        transaction.begin();
        Car car = entityManager.find(Car.class,6);
        entityManager.remove(car);
        // 5. 提交事务
        transaction.commit();
    }
    
    //修改
    @Test
    public void update(){
        transaction.begin();
        Query query = entityManager.createQuery("update from Car set color=:color where id=:id");
        query.setParameter("color","blue");
        query.setParameter("id",5);
        query.executeUpdate();
        transaction.commit();
    }
    @After
    public void closeEntity(){

        // 6. 关闭EntityManager
        entityManager.close();
        // 7. 关闭EntityManagerFactory
        factory.close();
    }
}
