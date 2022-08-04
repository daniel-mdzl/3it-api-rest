package com.example.apirest.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.model.Vote;
import com.example.apirest.model.Entry;
import com.example.apirest.repository.VoteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VoteController {
    
    @Autowired
    private VoteRepository voteRepository;

	@GetMapping("/entries")
    public ResponseEntity<List<Entry>> getAllEntries () {
        try{
            List<Object[]> votes = voteRepository.getEntries();
			List<Entry> entityList = new ArrayList<>();

            if (votes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
				for(Object[] obj : votes){
					Entry entity = new Entry(
						String.valueOf(obj[0]),
						Integer.valueOf(String.valueOf(obj[1]))
					);
					entityList.add(entity);
				}
				return new ResponseEntity<List<Entry>>(entityList, HttpStatus.OK);
			 }   
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

	@PostMapping("/vote")
	public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
		try{
			if(vote.getEmail() == null || vote.getEmail() == "" ){
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			} else {
				Vote response = voteRepository.save(vote);
				return new ResponseEntity<Vote>(response, HttpStatus.CREATED); 
			}
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
