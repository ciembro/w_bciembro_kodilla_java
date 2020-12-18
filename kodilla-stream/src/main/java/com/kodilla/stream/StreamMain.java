package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        //7.3
        Forum forum = new Forum();
        List<ForumUser> list = forum.getUserList();
        Map<Integer, ForumUser> users = list.stream()
                .filter(u -> u.getSex() == 'M')
                .filter(u ->  u.getBirthday().plusYears(20).isBefore(LocalDate.now()))
                .filter(u -> u.getNumOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        for (Map.Entry<Integer, ForumUser> user : users.entrySet()){
            System.out.println(user);
        }


//        People.getList().stream()
//                .map(s -> s.toUpperCase())
//                .filter(s -> s.length() > 11)
//                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
//                .filter(s -> s.substring(0, 1).equals("M"))
//                .forEach(System.out::println);


        //7.2
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        //ZADANIE 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text = "Ala ma kota";
        System.out.println(poemBeautifier.beautify(text, t -> t + " i psa"));
        System.out.println(poemBeautifier.beautify(text, t -> t.toUpperCase()));
        System.out.println(poemBeautifier.beautify(text, t -> "*** " + t + " ***"));
        System.out.println(poemBeautifier.beautify(text, t -> t.substring(0,4)));

    }
}