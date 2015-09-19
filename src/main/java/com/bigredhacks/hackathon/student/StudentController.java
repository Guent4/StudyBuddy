package com.bigredhacks.hackathon.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/student")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    // @RequestMapping(value="/login", method= RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody Student student)
    {
        String session = null;
        HttpStatus httpStatus = null;
        try
        {
            session = studentService.login(student);
        }
        catch(IllegalArgumentException ex)
        {
            httpStatus = HttpStatus.BAD_GATEWAY;
        }
        return new ResponseEntity<>(session, httpStatus);
    }
}