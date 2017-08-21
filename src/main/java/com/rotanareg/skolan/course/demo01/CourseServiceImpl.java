package com.rotanareg.skolan.course.demo01;

import com.rotanareg.skolan.course.Course;

import java.sql.SQLException;


public class CourseServiceImpl {

        public static void main(String[] args) throws SQLException, ClassNotFoundException {

            System.out.println("\n\n>>> Executing : " + CourseServiceImpl.class.toString() + " <<<\n");

            CourseService service = new CourseService();

            // Creates and persists a Course
            Course course = service.createCourse(1L, "ABC1", "Design och konstruktion av grafiska gränssnitt", "Kursen innehåller en genomgång av standardklasserna i ett välutvecklat grafiskt bibliotek, en översikt över vilka riktlinjer som krävs för att skapa lättanvända gränssnitt samt metoder för att iterativt utveckla och förbättra ett gränssnitt. Kursen ger praktisk erfarenhet i implementering samt användbarhet genom ett grupprojekt som ger en fördjupning av delmomentet kring grafiska komponenter från kursen Objektorienterad programvaruutveckling. Projektets mål är att utveckla en applikation för en specifik användargrupp och att genom att låta dessa testa programmet iterativt förbättra det", " Pernila","Johansson");

                    System.out.println("Course Persisted : " + course);

            // Finds the course
            course = service.findCourse(1L);

            System.out.println("Course Found     : " + course);

            // Removes the course
            service.removeCourse(1L);

            System.out.println("Course Removed");

            // Finds the Course
            course = service.findCourse(1L);

            System.out.println("Course Not Found : " + course);
        }
    }

