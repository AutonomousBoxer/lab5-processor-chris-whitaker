/**
 * Purpose: Reactive messaging processor that consumes Student messages from RabbitMQ and publishes messages as plain
 * text.
 * Author: Chris Whitaker
 */
package edu.franklin.lab5.chriswhitaker;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.Blocking;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class StudentProcessor {
    /**
     * Map a RabbitMQ JSON payload to the local Student DTO.
     *
     * @param json the JSON payload received from RabbitMQ
     * @return Student DTO
     */
    private Student toStudent(JsonObject json) {
        Student student = new Student();
        student.id = json.getInteger("id");
        student.name = json.getString("name");
        student.phone = json.getString("phone");
        Number gpaNumber = json.getNumber("gpa");
        student.gpa = gpaNumber != null ? gpaNumber.floatValue() : 0.0f;
        return student;
    }

    @Incoming("gpa40-students")
    @Outgoing("student-responses")
    @Blocking
    public String handlePresidentsList(JsonObject payload) {
        Student student = toStudent(payload);
        Log.infof("Processing President's List student: id=%d, name=%s, gpa=%.2f",
                student.id, student.name, student.gpa);

        String message = String.format(
                "Student id=%d, name=%s is added to the President's List (GPA=%.2f)",
                student.id, student.name, student.gpa
        );

        Log.infof("Publishing President's List acknowledgment: %s", message);
        return message;
    }

    @Incoming("gpa35-students")
    @Outgoing("student-responses")
    @Blocking
    public String handleDeansList(JsonObject payload) {
        Student student = toStudent(payload);
        Log.infof("Processing Dean's List student: id=%d, name=%s, gpa=%.2f",
                student.id, student.name, student.gpa);

        String message = String.format(
                "Student id=%d, name=%s is added to the Dean's List (GPA=%.2f)",
                student.id, student.name, student.gpa
        );

        Log.infof("Publishing Dean's List acknowledgment: %s", message);
        return message;
    }
}
