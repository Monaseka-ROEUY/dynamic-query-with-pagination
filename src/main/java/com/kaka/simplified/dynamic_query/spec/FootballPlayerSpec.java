package com.kaka.simplified.dynamic_query.spec;

import com.kaka.simplified.dynamic_query.entity.FootballPlayer;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
public class FootballPlayerSpec implements Specification<FootballPlayer> {
    // When declare field as final.It will create constructor automatically
    private final FootballPlayerFilter footballPlayerFilter;
    private List<Predicate> predicates = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<FootballPlayer> player, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (footballPlayerFilter.getFirstName() != null) {
            Predicate firstName = cb.like(cb.upper(player.get("firstName")),
                    "%" + footballPlayerFilter.getFirstName().toUpperCase() + "%");
            predicates.add(firstName);
        }
        if (footballPlayerFilter.getLastName() != null) {
            Predicate lastName = cb.like(cb.upper(player.get("lastName")),
                    "%" + footballPlayerFilter.getLastName().toUpperCase() + "%");
            predicates.add(lastName);
        }
        if (footballPlayerFilter.getPosition() != null) {
            Predicate position = cb.equal(player.get("position"), footballPlayerFilter.getPosition());
            predicates.add(position);
        }
        if (footballPlayerFilter.getJerseyNumber() != null) {
            Predicate jerseyNumber = cb.equal(player.get("jerseyNumber"), footballPlayerFilter.getJerseyNumber());
            predicates.add(jerseyNumber);
        }
        return cb.and(predicates.toArray(Predicate[]::new));
    }
}
