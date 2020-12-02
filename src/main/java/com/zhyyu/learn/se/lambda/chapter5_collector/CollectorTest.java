package com.zhyyu.learn.se.lambda.chapter5_collector;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhongyu.yzy
 * @date 2020/12/2
 */
public class CollectorTest {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setAge(1);

        Student student2 = new Student();
        student2.setAge(2);

        List<Student> students = Arrays.asList(student1, student2);
        Student maxAgeStudent = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge))).get();
        System.out.println(maxAgeStudent);

        Map<Boolean, List<Student>> collect = students.stream().collect(Collectors.partitioningBy(student -> student.getAge() == 1));
        System.out.println(collect);

        Map<Integer, List<Student>> collect2 = students.stream().collect(Collectors.groupingBy(student -> student.getAge()));
        System.out.println(collect2);

        String joiningStr = students.stream().map(student -> student.getAge() + "").collect(Collectors.joining(","));
        System.out.println(joiningStr);

        String joinStr2 = students.stream().map(student -> student.getAge() + "").collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinStr2);

        Map<Integer, Long> groupingDownstreamTest = students.stream().collect(Collectors.groupingBy(student -> student.getAge(), Collectors.counting()));
        System.out.println(groupingDownstreamTest);

        List<Integer> collectorMapping = students.stream().collect(Collectors.mapping(Student::getAge, Collectors.toList()));
        System.out.println(collectorMapping);

        Map<Integer, Set<Integer>> groupingByMappingTest = students.stream().collect(Collectors.groupingBy(student -> student.getAge(), Collectors.mapping(student -> student.getAge(), Collectors.toSet())));
        System.out.println(groupingByMappingTest);

        Map<String, String> strMap = new HashMap<>();
        strMap.put("a", "hello");
        strMap.put("b", "hi");

        strMap.forEach((key, value) -> {
            System.out.println("key: " + key);
            System.out.println("value: " + value);
        });
    }

    @Data
    private static class Student {
        private int age;
    }

}
