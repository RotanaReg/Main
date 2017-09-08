package com.rotanareg.skolan.registeredUserCoursePersist;import com.rotanareg.skolan.domains.*;

import javax.ejb.Local;
import java.util.List;@Local

public interface RegisteredUserCourseService {
    List<RegisteredUserCourseDomain> getRegisteredUserCourses();

    List<RegisteredUserCourseDomain> byUserId(Long userId);

    List<RegisteredUserCourseDomain> byCourseId(Long courseId);
}