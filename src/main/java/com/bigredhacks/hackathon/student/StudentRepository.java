package com.bigredhacks.hackathon.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
    public List<Student> findByEmailAndPassword(String email, String password);
    public List<Student> findBySession(String session);
}
