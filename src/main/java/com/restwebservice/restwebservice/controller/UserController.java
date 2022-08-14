package com.restwebservice.restwebservice.controller;


import com.restwebservice.restwebservice.model.User;


import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.util.*;

@Path("/user")
public class UserController {

    Map<Integer, User> userMap = new HashMap<>();


    @PostConstruct
    public void save(){
        User user = new User();
        user.setId(1L);
        user.setName("Test");
        userMap.put(1, user);
    }

    @GET
    @Produces("text/plain")
    @Path("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Produces("text/html")
    @Path("/the_weekend")
    public String html(){
        return "<video width=\"320\" height=\"240\" controls=\"\" autoplay=\"\">\n" +
                "  <source src=\"https://ia904506.us.archive.org/14/items/weeknd-daft-punk-starboy-prores/TW-DP_STARBOY_1627x915_Stereo_ProRes.mp4\" type=\"video/mp4\">\n" +
                "</video>";
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public User getUser(@QueryParam("id") int id){
        return userMap.get(id);
    }

    @GET
    @Produces("application/json")
    @Path("/list")
    public Collection<User> getUsers(){
        return userMap.values();
    }

    @POST
    @Produces("application/json")
    @Consumes({"application/json"})
    @Path("/save")
    public User save(User user){
        Random random = new Random();
        userMap.put(random.nextInt(20), user);
        return user;
    }




}