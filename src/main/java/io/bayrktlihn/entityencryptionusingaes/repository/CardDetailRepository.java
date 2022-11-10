package io.bayrktlihn.entityencryptionusingaes.repository;

import io.bayrktlihn.entityencryptionusingaes.entity.CardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDetailRepository extends JpaRepository<CardDetail, Integer> {
}
