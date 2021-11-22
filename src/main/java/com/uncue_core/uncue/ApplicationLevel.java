package com.uncue_core.uncue;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ApplicationLevel {
    public String tokenKey;
    public Map<String, String> LoggedInUsersList = new HashMap<String, String>();
    public Map<Integer,Integer>LoggedinUsersId=new HashMap<Integer,Integer>();
}
