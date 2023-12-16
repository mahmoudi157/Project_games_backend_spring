package com.games.app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.games.app.document.Maps;
import com.games.app.service.MapsService;

import java.util.List;

@RestController
@RequestMapping("/api/maps")
@Validated
public class MapsControler {

    @Autowired
    private MapsService mapsService;

    @PostMapping("/add")
    public ResponseEntity<?> addMaps(@RequestBody Maps maps) {
        return ResponseEntity.ok(mapsService.addmaps(maps));
    }

    @GetMapping()
    public List<Maps> findAll() {
        return mapsService.getallmaps();
    }

    @DeleteMapping("/delet/{id}")
    public boolean deleteById(@PathVariable String id) {
        return mapsService.deletmaps(id);
    }
}
