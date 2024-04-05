package application;

import entitys.Comment;
import entitys.Post;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss" );

        LocalDateTime moment1 = LocalDateTime.parse(("21/06/2018 13:05:44"), sdf);
        String title1 = "Traveling to New Zealand";
        String content1 = "I`m going to visit this wonderful contry";
        int likes = 12;

        Comment c1 = new Comment("Have a nice Trip!");
        Comment c2 = new Comment("Wow that´s awesome!");
        List<Comment> comments = new ArrayList<>();
        comments.add(c1);
        comments.add(c2);

        Post post1 = new Post(moment1, title1, content1, likes, comments);

        System.out.println(post1);






    }
}