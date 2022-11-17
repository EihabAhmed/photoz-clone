package com.bbk.photozclone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {

    private final PhotozService photozService;

    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = photozService.get(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = photozService.remove(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        /***********************************************/
//        (async function deletePhoto(id) {
//                await fetch('http://localhost:8080/photoz/' + id, {
//                method: "DELETE"
//            })})("1");
        /***********************************************/
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());

        /***********************************************/
//        (async function createPhoto() {
//            let photo = { "fileName": "hello.jpg"};
//            await fetch('http://localhost:8080/photoz', {
//                    method: "POST",
//                    headers: {
//                        Accept: 'application/json',
//                        'Content-Type': 'application/json'
//                    },
//                    body: JSON.stringify(photo)
//                }).then( result => result.text()).
//                    then( text => alert(text));
//            })();
        /***********************************************/
    }

//    @PutMapping("/photoz/{id}")
//    public Photo update(@PathVariable String id, @RequestBody @Valid Photo photo) {
//        if (photozService.contains(id)) {
//            photo.setId(id);
//            photozService.save(id, photo);
//            return photo;
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//    }
}

//39:30