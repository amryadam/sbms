package com.amryadam.sbms.repository.customer;

import com.amryadam.sbms.entities.customers.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
