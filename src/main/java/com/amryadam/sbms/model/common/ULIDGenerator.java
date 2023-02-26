package com.amryadam.sbms.model.common;

import io.azam.ulidj.ULID;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;


//TODO make use its unique , work  in high-volume  , multi-threaded environment
// https://blog.anorakgirl.co.uk/2009/01/custom-hibernate-sequence-generator-for-id-field/
// https://stackoverflow.com/questions/49980839/string-id-primary-key-generator-in-jpa-hibernate?noredirect=1&lq=1
// https://stackoverflow.com/questions/74447802/is-there-a-way-to-manage-a-custom-generated-id-with-identifiergenerator-from-hib
public class ULIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "STUDENT";
//        try {
//            Connection connection = session.connection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select count(id) from student");
//            if(resultSet.next()) {
//                Integer id = resultSet.getInt(1) + 1;
//                suffix = id.toString();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return  prefix + ULID.random();
    }
}
