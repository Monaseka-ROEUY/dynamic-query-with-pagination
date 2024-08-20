package com.kaka.simplified.dynamic_query.service.impl;

import com.kaka.simplified.dynamic_query.entity.FootballPlayer;
import com.kaka.simplified.dynamic_query.entity.Position;
import com.kaka.simplified.dynamic_query.repository.FootballPlayerRepository;
import com.kaka.simplified.dynamic_query.service.FootballPlayerService;
import com.kaka.simplified.dynamic_query.spec.FootballPlayerFilter;
import com.kaka.simplified.dynamic_query.spec.FootballPlayerSpec;
import com.kaka.simplified.dynamic_query.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FootballPlayerServiceImpl implements FootballPlayerService {
    private final FootballPlayerRepository footballPlayerRepository;


    @Override
    public FootballPlayer save(FootballPlayer footballPlayer) {
        return footballPlayerRepository.save(footballPlayer);
    }

    @Override
    public Optional<FootballPlayer> getPlayerById(Long id) {
        return footballPlayerRepository.findById(id);
    }

    public Page<FootballPlayer> getFootballPlayers(Map<String, String> params) {
        Pageable pageable = getPageable(params);
        FootballPlayerSpec footballPlayerSpec = getFootballPlayerSpec(params);
        return footballPlayerRepository.findAll(footballPlayerSpec, pageable);
    }

    private FootballPlayerSpec getFootballPlayerSpec(Map<String, String> params) {
        var footballPlayerFilter = new FootballPlayerFilter();
        if (params.containsKey("firstName")) {
            String firstName = params.get("firstName");
            footballPlayerFilter.setFirstName(firstName);
        }
        if (params.containsKey("lastName")) {
            String lastName = params.get("lastName");
            footballPlayerFilter.setLastName(lastName);
        }
        if (params.containsKey("position")) {
            String position = params.get("position");
            footballPlayerFilter.setPosition(Position.valueOf(position.toUpperCase()));
        }
        if (params.containsKey("number")) {
            String jerseyNumber = params.get("number");
            footballPlayerFilter.setJerseyNumber(Integer.parseInt(jerseyNumber));
        }
        return new FootballPlayerSpec(footballPlayerFilter);
    }

    private Pageable getPageable(Map<String, String> params) {
        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        int pageSize = PageUtil.DEFAULT_PAGE_SIZE;

        if (params.containsKey("page")) {
            pageNumber = Integer.parseInt(params.get("page"));
        }
        if (params.containsKey("size")) {
            pageSize = Integer.parseInt(params.get("size"));
        }

        return PageUtil.getPageable(pageNumber, pageSize);
    }

}
