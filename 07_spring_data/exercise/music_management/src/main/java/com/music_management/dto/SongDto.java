package com.music_management.dto;

import com.music_management.unit.VnCharacterUnit;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.naming.Name;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private Long id;
    @NotBlank
    @Size(min = 2, max = 800, message = "Name must contain at least 2 characters and maximum 800 characters")
    private String songName;
    @NotBlank
    @Size(min = 2, max = 800, message = "Name must contain at least 2 characters and maximum 300 characters")
    private String singleName;
    @NotBlank
    @Size(min = 2, max = 800, message = "Name must contain at least 2 characters and maximum 1000 characters")
    private String category;

    public SongDto() {
    }

    public SongDto(String songName, String singleName, String category) {
        this.songName = songName;
        this.singleName = singleName;
        this.category = category;
    }

    public SongDto(Long id, String songName, String singleName, String category) {
        this.id = id;
        this.songName = songName;
        this.singleName = singleName;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingleName() {
        return singleName;
    }

    public void setSingleName(String singleName) {
        this.singleName = singleName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

            String songName = VnCharacterUnit.removeAccent(songDto.songName);
            if (!songName.matches("^[A-Za-z ]+$")) {
                errors.rejectValue("songName", "wrong.create","* Please input right format!");
            }

            String singleName = VnCharacterUnit.removeAccent(songDto.singleName);
            if (!singleName.matches("^([A-Z][a-z]+\\s?){1,4}$")){
                errors.rejectValue("singleName", "wrong.create","* Please input right format!");
            }
            String category = VnCharacterUnit.removeAccent(songDto.category);
            if (!category.matches("^[A-Za-z ,]+$")){
                errors.rejectValue("category", "wrong.create","* Please input right format!");
            }
    }
}
