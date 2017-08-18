package com.rotanareg.skolan;

/**
 * Created by Marko K. Seppänen.
 */
public enum Role {
    STUDENT, TEACHER, ADMIN;

    @Override
    public String toString() {
        switch (this) {
            case STUDENT:
                return "Student";
            case TEACHER:
                return "Teacher";
            case ADMIN:
                return "Admin";
        }

        return "--not defined--";   // should never happen
    }
}
