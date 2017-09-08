package com.rotanareg.skolan.registeredUserCoursePersist;

import java.io.Serializable;

public class RegisteredUserCourseId implements Serializable {
    private long userId;
    private long courseId;

    @Override
    public int hashCode() {
        return (int) (userId + courseId);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RegisteredUserCourseId) {
            RegisteredUserCourseId otherId = (RegisteredUserCourseId) o;
            return (otherId.userId == this.userId) && (otherId.courseId == this.courseId);
        }
        return false;
    }
}
