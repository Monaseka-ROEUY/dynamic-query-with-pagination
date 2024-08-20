package com.kaka.simplified.dynamic_query.service;

import com.kaka.simplified.dynamic_query.entity.FootballPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public interface FootballPlayerService {
    FootballPlayer save(FootballPlayer footballPlayer);

    Optional<FootballPlayer> getPlayerById(Long id);

    Page<FootballPlayer> getFootballPlayers(Map<String, String> params);
}
