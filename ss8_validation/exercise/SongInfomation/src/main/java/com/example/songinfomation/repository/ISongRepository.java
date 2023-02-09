package com.example.songinfomation.repository;

import com.example.songinfomation.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByName(String name);
}
