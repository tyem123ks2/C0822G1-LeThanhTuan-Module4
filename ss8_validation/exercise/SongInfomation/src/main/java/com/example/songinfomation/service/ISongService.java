package com.example.songinfomation.service;

import com.example.songinfomation.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> showInfo();

    boolean addNewSong(Song song);

    boolean updateSong(Song Song);
}
