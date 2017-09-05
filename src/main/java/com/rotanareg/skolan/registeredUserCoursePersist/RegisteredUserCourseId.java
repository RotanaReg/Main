package com.rotanareg.skolan.registeredUserCoursePersist;

import java.io.Serializable;

/**
 * Created by Nils Gerstner on 2017-08-31.
 */
public class RegisteredUserCourseId implements Serializable {
    private long personId;
    private long courseId;

    @Override
    public int hashCode() {
        return (int) (personId + courseId);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RegisteredUserCourseId) {
            RegisteredUserCourseId otherId = (RegisteredUserCourseId) o;
            return (otherId.personId == this.personId) && (otherId.courseId == this.courseId);
        }
        return false;
    }
}
