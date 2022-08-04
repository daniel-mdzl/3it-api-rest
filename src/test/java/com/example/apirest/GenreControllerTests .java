package com.example.apirest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.example.apirest.Controller.GenreController;
import com.example.apirest.model.Genre;
import com.example.apirest.repository.GenreRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GenreControllerTests {

	@Mock
    private GenreRepository genreRepository;

	@Mock
	private GenreController genreController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(genreController).isNotNull();
	}

	@DisplayName("Should return a http response OK with a list of three genres")
    @Test
	public void getGenres()
	{
		List<Genre> list = new ArrayList<Genre>();
		Genre genreOne = new Genre(new Long(1), "ROCK");
		Genre genreTwo = new Genre(new Long(2), "LO-FI");
		Genre genreThree = new Genre(new Long(3), "HIP-HOP");

		list.add(genreOne);
		list.add(genreTwo);
		list.add(genreThree);

		doReturn(list).when(genreController).findAll();

		//test
		List<Genre> response = genreController.findAll();

		assertEquals(3, response.size());
		verify(genreController, times(1)).findAll();
	}

}
