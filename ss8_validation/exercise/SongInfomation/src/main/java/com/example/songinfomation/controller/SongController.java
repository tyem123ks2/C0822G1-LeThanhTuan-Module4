package com.example.songinfomation.controller;

import com.example.songinfomation.dto.SongDto;
import com.example.songinfomation.model.Song;
import com.example.songinfomation.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/show-list")
    public  String showListSong(Model model){
        List<Song> songList = songService.showInfo();
        model.addAttribute("listSong", songList);
        Song song = new Song();
        model.addAttribute("song", song);
        return "/list";
    }

    @GetMapping("/show-create-song")
    public String createNewSong(Model model){
        Song song = new Song();
        model.addAttribute("song", song);
        return "/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("songDto", songDto);
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        redirectAttributes.addFlashAttribute("messasge", "Thêm mới bài hát thành công");
        return "/list";
    }
}
