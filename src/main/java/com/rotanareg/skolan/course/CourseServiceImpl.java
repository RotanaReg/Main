package com.rotanareg.skolan.course;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CourseServiceImpl implements CourseService {

 private final Map<Long, Course> courses;
 
 private final List<Course> mostStudiedCourses;
 
 public CourseServiceImpl (){
	 Map<Long, Course> map = new HashMap<>();
	 map.put(1L, new Course(1L,"Design och konstruktion av grafiska gränssnitt","Kursen innehåller en genomgång av standardklasserna i ett välutvecklat grafiskt bibliotek, en översikt över vilka riktlinjer som krävs för att skapa lättanvända gränssnitt samt metoder för att iterativt utveckla och förbättra ett gränssnitt. Kursen ger praktisk erfarenhet i implementering samt användbarhet genom ett grupprojekt som ger en fördjupning av delmomentet kring grafiska komponenter från kursen Objektorienterad programvaruutveckling. Projektets mål är att utveckla en applikation för en specifik användargrupp och att genom att låta dessa testa programmet iterativt förbättra det."));
	 map.put(2L, new Course(2L," Objektorienterad programmering","Grundläggande begrepp i objektorienterad programutveckling. Vad som skiljer det objektorienterade synsättet från andra synsätt.I kursen används programspråket Java. Momenten så som objekt och klass, datainkapsling,konstruktorer, metoder, instansvariabler, klassvariabler  behandals men även modularisering av program, användning av dokumentation för standardbibliotek, användning av standardklasser för datasamlingar samt kodningsstandard, namnsättning och kommentering. Testning av program också ingår i kursen och det behandlas även arv, dynamisk bindning och polymorfism, abstrakta klasser och gränssnitt, grafiska användargränssnitt, händelser och lyssnare."));
	 map.put(3L, new Course(3L,"Datastrukturer","Abstrakta datatyper. Enkel komplexitetsanalys. Vanliga datastrukturer som fält, listor, träd och hashtabeller samt hur dessa kan användas för att implementera abstrakta datatyper som köer, prioritetsköer, lexika och grafer. Standardalgoritmer för dessa datastrukturer och deras resurskrav. Iteratorer. Sorteringsalgoritmer. Standardbibliotek för datastrukturer och algoritmer."));
 
 courses =Collections.unmodifiableMap(map);
 mostStudiedCourses = Collections.unmodifiableList(new ArrayList<>(courses.values()));
 
}
 @Override
  public List<Course> getMostStudiedCourses() {
	  return mostStudiedCourses;
  }
   @Override
   public Course getCourse (long id) {
	   return courses.get(id);
  
   }
}
