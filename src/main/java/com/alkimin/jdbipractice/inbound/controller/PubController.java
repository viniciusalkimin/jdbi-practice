package com.alkimin.jdbipractice.inbound.controller;

import com.alkimin.jdbipractice.core.domain.entity.Pub;
import com.alkimin.jdbipractice.core.domain.service.PubService;
import com.alkimin.jdbipractice.inbound.dto.CreatePubRecord;
import com.alkimin.jdbipractice.inbound.dto.ParamSearch;
import com.alkimin.jdbipractice.inbound.dto.PubCreatedRecord;
import com.alkimin.jdbipractice.inbound.dto.PubListRecord;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pubs")
@AllArgsConstructor
public class PubController {

    private PubService pubService;

    @GetMapping
    public ResponseEntity<String> helloPubs() {
        return ResponseEntity.ok().body("Hello pubs.");
    }

    @PostMapping
    public ResponseEntity<PubCreatedRecord> create(@RequestBody CreatePubRecord createPubRecord) {
        var pub = pubService.create(createPubRecord);
        return ResponseEntity.ok().body(pub);
    }

    @PostMapping("/find")
    public ResponseEntity<List<PubListRecord>> getByParameter(@RequestBody ParamSearch paramSearch){
        return ResponseEntity.ok().body(pubService.findByParameter(paramSearch));
    }


}
