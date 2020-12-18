package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class Forum {

    private final List<ForumUser> userList = new LinkedList<>();

    public Forum(){
        Random random = new Random();
        for (int i = 1; i < 10; i++){
            userList.add(new ForumUser(i,"user" + i,'F',
                    LocalDate.of(1990+i,i,random.nextInt(29)+1),
                    random.nextInt(100)));
        }
        for (int i = 1; i < 11; i++){
            userList.add(new ForumUser(i+10,"user"+(i+10),'M',
                    LocalDate.of(random.nextInt(30)+1985,i,random.nextInt(29)+1),
                    random.nextInt(100)));
        }
    }

    public List<ForumUser> getUserList(){
        return new LinkedList<>(userList);
    }




}
