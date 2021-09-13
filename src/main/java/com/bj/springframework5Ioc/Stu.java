package com.bj.springframework5Ioc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    private String[] course;

    private List<String> list;

    private Map<String,String> map;

    private Set<String> set;

    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "[" +
                "course=" + Arrays.toString(course) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", courseList=" + courseList +
                ']';
    }
}
