/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthtrackapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
/**
 *
 * @author BIMAZZNXT
 */
public class SessionManager {
        private static final String SESSION_FILE = "session.json";

    public static void save(UserSession session) {
        try (FileWriter writer = new FileWriter(SESSION_FILE)) {
            Cache<UserSession> cache = new Cache<>(session);
            Gson gson = new Gson();
            gson.toJson(cache, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserSession load() {
        try (FileReader reader = new FileReader(SESSION_FILE)) {
            Gson gson = new Gson();
            Cache<UserSession> cache = gson.fromJson(reader, new TypeToken<Cache<UserSession>>() {}.getType());
            return cache.getData();
        } catch (IOException e) {
            return null;
        }
    }

    public static void clear() {
        new File(SESSION_FILE).delete();
    }
}
