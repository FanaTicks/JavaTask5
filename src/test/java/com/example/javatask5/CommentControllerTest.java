package com.example.javatask5;

import com.example.javatask5.comtroller.CommentController;
import com.example.javatask5.model.Comment;
import com.example.javatask5.model.Tutorial;
import com.example.javatask5.repository.CommentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    CommentRepository commentRepository;

    @AfterEach
    public void resetDb() {
        commentRepository.deleteAll();
    }

    Comment comment1 = new Comment(1,"adw",new Tutorial(1,"adw","daw",true));
    Comment comment2 = new Comment(2,"adwadw",new Tutorial(2,"adwadw","dagdrw",true));
    Comment comment3 = new Comment(3,"adfsew",new Tutorial(3,"adfsew","dhfaw",true));
    Comment comment4 = new Comment(4,"adw",new Tutorial(1,"adw","daw",true));
    Comment comment5 = new Comment(5,"adw",new Tutorial(1,"adw","daw",true));
    Comment comment6 = new Comment(6,"adw",new Tutorial(1,"adw","daw",true));
    Comment comment7 = new Comment(7,"adw",new Tutorial(1,"adw","daw",true));

    @Test
    public void contectLoads() throws Exception{
        assertThat(commentRepository).isNotNull();
    }

    @Test
    public void getAllComment() throws Exception {
        List<Comment> records = new ArrayList<>(Arrays.asList(comment1, comment2, comment3));

        Mockito.when(commentRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/comments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].content", Matchers.is("adfsew")));

    }

    @Test
    public void getCommentsByTutorialId() throws Exception {
        List<Comment> records = new ArrayList<>(Arrays.asList(comment1,comment6,comment7));

        Mockito.when(commentRepository.findCommentByContentAndAndTutorial("adw", new Tutorial(1,"adw","daw",true))).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/comment/adw/1/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is("1")));

    }

    @Test
    public void createComment_success() throws Exception {



        Tutorial tutorial = Tutorial.builder()
                .id(2)
                .title("47")
                .description("fes")
                .published(true)
                .build();

        Comment record = Comment.builder()
                .id(2)
                .content("47")
                .tutorial(tutorial)
                .build();
        Mockito.when(commentRepository.save(record)).thenReturn(record);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("47")));
    }

    @Test
    public void updateCommentRecord_success() throws Exception {


        Tutorial tutorial = Tutorial.builder()
                .id(1)
                .title("adw")
                .description("daw")
                .published(true)
                .build();

        Comment record = Comment.builder()
                .id(1)
                .content("47")
                .tutorial(tutorial)
                .build();

        Mockito.when(commentRepository.findById(comment1.getId())).thenReturn(Optional.of(comment1));
        Mockito.when(commentRepository.save(record)).thenReturn(record);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/update")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("47")));
    }

    @Test
    public void updatePatientRecord_nullId() throws Exception {
        Tutorial tutorial = Tutorial.builder()
                .title("adw")
                .description("daw")
                .published(true)
                .build();

        Comment record = Comment.builder()
                .id(1)
                .content("47")
                .tutorial(tutorial)
                .build();

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/update")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(tutorial));

        mockMvc.perform(mockRequest)
                .andExpect(status().isBadRequest())
                .andExpect(result ->
                        assertTrue(result.getResolvedException() instanceof CommentController.InvalidRequestException))
                .andExpect(result ->
                        assertEquals("Comment or ID must not be null!", result.getResolvedException().getMessage()));
    }

    @Test
    public void deleteCommentById() throws Exception {
        Mockito.when(commentRepository.findById(comment2.getId())).thenReturn(Optional.of(comment2));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/delete/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
