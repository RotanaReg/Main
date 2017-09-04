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
                return "Lärare";
            case ADMIN:
                return "Administratör";
        }

        return "--not defined--";   // should never happen
    }
}
