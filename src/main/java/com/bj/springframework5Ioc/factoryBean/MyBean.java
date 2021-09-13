package com.bj.springframework5Ioc.factoryBean;

import com.bj.springframework5Ioc.Course;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Course> {


    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
