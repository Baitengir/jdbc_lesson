package org.example;

import org.example.dao.userDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        userDao userDao = new userDao();
//        userDao.createUserTable();
//
//        userDao.saveUser("Karylgach", "1345");

        userDao.deleteUser(1L);
    }

}
