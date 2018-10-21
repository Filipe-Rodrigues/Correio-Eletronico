/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correio.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filipe
 */
public class TestingUtils {

    public static Map<String, String> loadTemplateUsersFromFile() {
        String txtFilePath = System.getProperty("user.dir") + "/default_users.txt";
        File txtFile = new File(txtFilePath);
        try {
            FileReader fr = new FileReader(txtFile);
            BufferedReader input = new BufferedReader(fr);
            String line;
            Map<String, String> users = new HashMap<>();
            while ((line = input.readLine()) != null) {
                users.put(line.split(" ")[0], line.split(" ")[1]);
            }
            return users;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestingUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestingUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
