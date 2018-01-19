package com.project.lookify.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.lookify.models.Song;

@Repository 												
public interface SongRepository extends CrudRepository<Song,Long>{
	// Query methods go here.
	public ArrayList<Song> findByArtistContaining(String search);

	public ArrayList<Song> OrderByRatingDesc();
	// Example:
	// public YourModelHere findByName(String name);
}
