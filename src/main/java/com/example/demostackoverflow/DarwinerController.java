package com.example.demostackoverflow;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/darwiner")
public class DarwinerController {

    private final DarwinerRepositoryImpl darwinerRepositoryImpl;

    public DarwinerController(DarwinerRepositoryImpl darwinerRepositoryImpl) {
        this.darwinerRepositoryImpl = darwinerRepositoryImpl;
    }


    @GetMapping(value = "/allDarwins", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Set<Darwiner> findAllDarwinerNames() {
        return darwinerRepositoryImpl.findAll();
    }

    @GetMapping(value = "/darwinNameById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Darwiner findDarwinerNameById(@RequestBody @PathVariable @Validated Long id) {
        return darwinerRepositoryImpl.findById(id);
    }

    @PostMapping(value = "/saveDarwinName", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity saveDarwinerName(@RequestBody Darwiner darwiner) {
        darwinerRepositoryImpl.save(darwiner);
        return ResponseEntity.ok(HttpStatus.OK + " Darwiner name has been successfully saved to database");
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity deleteDarwinerNameById(@RequestBody @PathVariable Long id) {
        darwinerRepositoryImpl.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK + " Darwin has been successfully removed");
    }
}
