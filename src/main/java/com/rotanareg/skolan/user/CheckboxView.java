package com.rotanareg.skolan.user;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

   @ ManagedBean
    public class CheckboxView {

       private String[] selectedRoll;
        private List<String> roll;

       @PostConstruct
       public void init() {
           roll = new ArrayList<String>();
           roll.add("Admin");
           roll.add("Teacher");
           roll.add("Student");

       }
           public String[] getSelectedRoll() {
               return selectedRoll;
           }

           public void setSelectedRoll(String[] selectedRoll) {
               this.selectedRoll = selectedRoll;
           }

       public List<String> getRoll() {
           return roll;
       }



   }