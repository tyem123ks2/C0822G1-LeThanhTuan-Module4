package com.example.songinfomation.service.impl;

import com.example.songinfomation.model.Song;
import com.example.songinfomation.repository.ISongRepository;
import com.example.songinfomation.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override

    public List<Song> showInfo() {
        return songRepository.findAll();
    }

    @Override
    public boolean addNewSong(Song song) {
        try {
            if (songRepository.findByName(song.getName()) == null) {
                throw new SQLDataException();
            }
            songRepository.save(song);
        } catch (IllegalArgumentException | OptimisticLockingFailureException | SQLDataException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSong(Song song) {
        if (!songRepository.existsById(song.getId())) {
            return false;
        }
        try {
            songRepository.save(song);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
