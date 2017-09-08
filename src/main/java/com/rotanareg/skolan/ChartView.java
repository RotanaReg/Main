package com.rotanareg.skolan;

import com.rotanareg.skolan.coursePersist.CourseService;
import com.rotanareg.skolan.domains.Course;
import com.rotanareg.skolan.domains.RegisteredUserCourseDomain;
import com.rotanareg.skolan.domains.User;
import com.rotanareg.skolan.registeredUserCoursePersist.RegisteredUserCourseService;
import com.rotanareg.skolan.userPersist.UserService;
import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ManagedBean
public class ChartView implements Serializable {

    // hämta in currentUser ifrån SignIn bönan
    @ManagedProperty("#{signInBean.currentUser}")
    private User user;

    @EJB
    RegisteredUserCourseService rucService;
    @EJB
    UserService userService;
    @EJB
    CourseService courseService;

    List<RegisteredUserCourseDomain> rucdList = rucService.byUserId(user.getId());

    private BarChartModel barModel;


    @PostConstruct
    public void init() {
        createBarModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }


    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        Set<String> rucSet = new HashSet<>();
        List<User> users = userService.getUsers();
        List<Course> myCourses = courseService.getCourses();
        for(RegisteredUserCourseDomain s: rucdList){
            for(Course c : myCourses){
                if (c.getId()==s.getCourseId())
                    rucSet.add(c.getCourseCode());
            }
        }
        ChartSeries courses = new ChartSeries();
        courses.setLabel("Courses");
        for (String s : rucSet){
            courses.set(s);
        }




        courses.set("E1234A", 100);
        courses.set("Sv234B", 100);
        courses.set("DK234C", 44);
        courses.set("DR256C", 90);
        courses.set("KG289M", 25);

        LineChartSeries hasAttended = new LineChartSeries();

        hasAttended.setLabel("Närvaro");
        hasAttended.setXaxis(AxisType.X2);
        hasAttended.set("Januari", 10);
        hasAttended.set("Februari", 10);
        hasAttended.set("Mars", 10);
        hasAttended.set("April", 185);
        hasAttended.set("Maj", 12);
        hasAttended.set("Juni",23 );

        model.addSeries(courses);
        model.addSeries(hasAttended);



        if (user != null) {
            model.setTitle(user.getName() + " " + user.getLastName() + "s närvaro");
        } else {
            model.setTitle("Din närvaro");
        }
        return model;
    }

    private void createBarModels() {
        createBarModel();

    }

    private void createBarModel() {
        barModel = initBarModel();

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Courses");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Närvaro");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

}
