package com.perfectorial;

import com.perfectorial.controller.URIConstants;
import com.perfectorial.entity.Category;
import com.perfectorial.entity.Course;
import com.perfectorial.entity.Session;
import com.perfectorial.entity.SessionFile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 * @author Mohsen Ebrahimi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:mvc-dispatcher-servlet.xml")
public class CategoryTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private MongoOperations mongoOperations;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        removeAllCollections();
    }

    private void removeAllCollections() {
        mongoOperations.getCollectionNames().stream()
                .filter(collectionName -> !collectionName.equals("system.indexes"))
                .forEach(mongoOperations::dropCollection);
    }

    @Test
    public void testGetAllCategories() throws Exception {
        postCategory().andExpect(status().isOk());
        getCategories().andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name", hasValue("Dummy")));
    }

    @Test
    public void testGetCategory() throws Exception {
        ResultActions result = postCategory().andExpect(status().isOk());
        String id = String.valueOf(getModelProperty(result));
        mockMvc.perform(get(URIConstants.Category.CATEGORY, id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name", hasValue("Dummy")));
    }

    private Object getModelProperty(ResultActions resultActions) {
        return resultActions.andReturn().getModelAndView().getModel().get("id");
    }

    @Test
    public void testCreateCategory() throws Exception {
        postCategory().andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    private ResultActions getCategories() throws Exception {
        return mockMvc.perform(get(URIConstants.Category.CATEGORIES)
                .accept(MediaType.APPLICATION_JSON));
    }

    private ResultActions postCategory() throws Exception {
        return mockMvc.perform(post(URIConstants.Category.CATEGORIES)
                .content(JsonUtil.asJsonString(buildCategory()))
                .contentType(MediaType.APPLICATION_JSON));
    }

    private Category buildCategory() {
        final Category category = new Category();
        category.setName("Dummy");
        category.setLatinName("Latin Dummy");
        category.setCode("DUM");
        category.setDescription("Just for a dummy test");
        category.setParentCode("DUF");
        category.setParentName("Dummy Father");
        category.setKeywords(Arrays.asList("Dummy", "Foolish", "Silly"));
        return category;
    }

    private List<Course> getCourses() {
        Course course = new Course();
        course.setImage(new byte[]{1, 2});
        course.setName("course");
        course.setDescription("courseDescription");
        course.setLatinName("course");
        course.setKeywords(Arrays.asList("key4", "key5"));
//        course.setSessions(getSessions());
        return Collections.singletonList(course);
    }

    private List<Session> getSessions() {
        Session session = new Session();
        session.setImage(new byte[]{1, 2});
        session.setName("course");
        session.setDescription("courseDescription");
        session.setLatinName("course");
        session.setKeywords(Collections.singletonList("key1,key2"));
//        session.setSessionFiles(getFiles());
        return Collections.singletonList(session);
    }

    private List<SessionFile> getFiles() {
        SessionFile sessionFile = new SessionFile();
        sessionFile.setImage(new byte[]{1, 2});
        sessionFile.setName("course");
        sessionFile.setDescription("courseDescription");
        sessionFile.setLatinName("course");
        sessionFile.setKeywords(Collections.singletonList("key1,key2"));
        sessionFile.setFileType("pdf");
        sessionFile.setDownloadUrl("DownloadUrl");
        return Collections.singletonList(sessionFile);
    }
}
