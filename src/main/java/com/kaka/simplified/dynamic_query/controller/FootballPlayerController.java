package com.kaka.simplified.dynamic_query.controller;

import com.kaka.simplified.dynamic_query.dto.PageDto;
import com.kaka.simplified.dynamic_query.entity.FootballPlayer;
import com.kaka.simplified.dynamic_query.service.FootballPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/players")
@RequiredArgsConstructor
public class FootballPlayerController {
    private final FootballPlayerService footballPlayerService;

    @PostMapping
    public ResponseEntity<?> savePlayer(@RequestBody FootballPlayer player) {
        FootballPlayer savedPlayer = footballPlayerService.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable Long id) {
        Optional<FootballPlayer> player = footballPlayerService.getPlayerById(id);
        if (player.isEmpty()) {
            // Should use customize exception with @ControllerAdvice
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Player with id = %d NOT FOUND", id));
        }
        return ResponseEntity.ok(player.get());
    }

    @GetMapping
    public ResponseEntity<?> getPlayers(@RequestParam Map<String, String> params) {
        Page<FootballPlayer> footballPlayers = footballPlayerService.getFootballPlayers(params);
        PageDto pageDto = new PageDto(footballPlayers);
        return ResponseEntity.ok(pageDto);
    }
}
