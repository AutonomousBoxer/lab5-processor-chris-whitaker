/**
 * Purpose: DTO for a student consumed by the processor.
 * Author: Chris Whitaker
 */
package edu.franklin.lab5.chriswhitaker;

public class Student {
    public int id;
    public String name;
    public String phone;
    public float gpa;

    @Override
    public String toString() {
        return "id=" +  id + ", name=" + name + ", phone=" + phone + ", gpa=" + gpa;
    }
}
