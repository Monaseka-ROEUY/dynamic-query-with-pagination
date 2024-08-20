package com.kaka.simplified.dynamic_query.repository;

import com.kaka.simplified.dynamic_query.entity.FootballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballPlayerRepository extends JpaRepository<FootballPlayer, Long>, JpaSpecificationExecutor<FootballPlayer> {
}