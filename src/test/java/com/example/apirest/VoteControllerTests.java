package com.example.apirest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.example.apirest.Controller.VoteController;
import com.example.apirest.model.Entry;
import com.example.apirest.model.Genre;
import com.example.apirest.model.Vote;
import com.example.apirest.repository.GenreRepository;
import com.example.apirest.repository.VoteRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class VoteControllerTests {

	@Mock
	private VoteRepository voteRepository;

	@Mock
    private GenreRepository genreRepository;

	@Mock
	private VoteController voteController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(voteController).isNotNull();
	}

	@DisplayName("Should return a http response OK with a list of three entries")
    @Test
	public void getEntriesTest()
	{
		List<Entry> list = new ArrayList<Entry>();
		Entry voteOne = new Entry("ROCK", 10);
		Entry voteTwo = new Entry("LO-FI", 11);
		Entry voteThree = new Entry("HIP-HOP", 5);

		list.add(voteOne);
		list.add(voteTwo);
		list.add(voteThree);

		ResponseEntity<List<Entry>> request = ResponseEntity.ok(list);

		doReturn(request).when(voteController).getAllEntries();

		//test
		ResponseEntity<List<Entry>> response = voteController.getAllEntries();

		assertEquals(3, response.getBody().size());
		verify(voteController, times(1)).getAllEntries();
	}

	@DisplayName("Should return a http response OK")
	@Test
	public void createVote()
	{
		Vote vote = new Vote(new Long(1), "some@email.cl", new Genre(new Long(1), "JAZZ"));
		voteController.createVote(vote);
		verify(voteController, times(1)).createVote(vote);
	}

}
