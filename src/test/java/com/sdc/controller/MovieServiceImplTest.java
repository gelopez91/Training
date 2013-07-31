package com.sdc.controller;

import com.sdc.controller.BackEntities.ActorB;
import com.sdc.controller.BackEntities.Movie;
import junit.framework.TestCase;
import com.sdc.controller.FrontEntities.ActorF;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MovieServiceImplTest extends TestCase {

    private MovieServiceImpl movieService = new MovieServiceImpl();
    @Mock
    private MovieDAO movieDAO;

    @Before
    public void setUp(){
        initMocks(this);
        movieService.setMovieDAO(movieDAO);
    }

    @Test
    public void testAddActor() {
        ActorF actor = new ActorF();
        actor.setFirstName("John");
        actor.setLastName("Smith");
        actor.setMovie_id(1);

        ArgumentCaptor<ActorB> argumentCaptor = ArgumentCaptor.forClass(ActorB.class);

        when(movieDAO.addActor(argumentCaptor.capture())).thenReturn("Exito");

        String response = movieService.addActor(actor);

        ActorB a = argumentCaptor.getValue();

        assertEquals("John", a.getFirstName());
        assertEquals("Smith", a.getLastName());
        assertEquals("Exito", response);
    }

    @Test
    public void testGetMovie(){

        Movie m = new Movie();
        m.setName("test");
        when(movieDAO.getMovie(eq(1))).thenReturn(m);

        Movie movie = movieService.getMovie(1);

        assertNotNull(movie.getName());
    }
}
