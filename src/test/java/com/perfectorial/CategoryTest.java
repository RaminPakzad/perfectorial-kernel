package com.perfectorial;

import com.perfectorial.entity.Category;
import com.perfectorial.entity.Course;
import com.perfectorial.entity.Session;
import com.perfectorial.entity.SessionFile;
import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
public class CategoryTest {

    @Test
    public void createCategory() {
        Category category = new Category();
        category.setImage(new byte[]{1, 2});
        category.setName("category");
        category.setDescription("description");
        category.setLatinName("category");
        category.setKeywords(Arrays.asList("key1", "key2"));
//        category.setCreateCourseRequests(getCourses());
        JSONObject jsonObject = new JSONObject(category);
        try {
            URL url = new URL("http://localhost:8080/getCategories");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(jsonObject.toString());
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String result = "";
            String s;
            while ((s = in.readLine()) != null) {
                result += s;
            }
            System.out.println(result);
            System.out.println("\nREST Service Invoked Successfully..");
            in.close();
        } catch (Exception e) {
            System.out.println("\nError while calling REST Service");
        }

    }

    private List<Course> getCourses() {
        Course course = new Course();
        course.setImage(new byte[]{1, 2});
        course.setName("course");
        course.setDescription("courseDescription");
        course.setLatinName("course");
        course.setKeywords(Arrays.asList("key4", "key5"));
//        course.setSessions(getSessions());
        return Arrays.asList(course);
    }

    private List<Session> getSessions() {
        Session session = new Session();
        session.setImage(new byte[]{1, 2});
        session.setName("course");
        session.setDescription("courseDescription");
        session.setLatinName("course");
        session.setKeywords(Arrays.asList("key1,key2"));
//        session.setSessionFiles(getFiles());
        return Arrays.asList(session);
    }

    private List<SessionFile> getFiles() {
        SessionFile sessionFile = new SessionFile();
        sessionFile.setImage(new byte[]{1, 2});
        sessionFile.setName("course");
        sessionFile.setDescription("courseDescription");
        sessionFile.setLatinName("course");
        sessionFile.setKeywords(Arrays.asList("key1,key2"));
        sessionFile.setFileType("pdf");
        sessionFile.setDownloadUrl("DownloadUrl");
        return Arrays.asList(sessionFile);
    }

}
