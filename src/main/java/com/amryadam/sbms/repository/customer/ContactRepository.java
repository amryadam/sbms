package com.amryadam.sbms.repository.customer;

import com.amryadam.sbms.models.entities.customers.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContactRepository extends JpaRepository<Contact,String> {
}
