package com.example.PLDSMARTBackEnd.util;

public class UtilLDAP {

    public static String generateUserDN(String uid){
        return "uid=" + uid + ",ou=people,dc=springframework,dc=org";
    }
}
