package io.bayrktlihn.entityencryptionusingaes;

import io.bayrktlihn.entityencryptionusingaes.config.AesEncryptor;
import io.bayrktlihn.entityencryptionusingaes.entity.CardDetail;
import io.bayrktlihn.entityencryptionusingaes.repository.CardDetailRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class EntityEncryptionUsingAesApplicationTest {


    @Autowired
    private CardDetailRepository cardDetailRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void insertData() {
        CardDetail cardDetail = new CardDetail();
        cardDetail.setCardHolderName("alihan bayraktar");
        cardDetail.setCvv(123);
        cardDetail.setAmount(100.00);
        cardDetail.setIsActive(false);

        cardDetailRepository.save(cardDetail);
    }

    @Test
    void retrieveData(){

        insertData();

        Query nativeQuery = entityManager.createNativeQuery("select cd.card_holder_name, cd.cvv from card_detail cd");
        List<Object[]> resultList = nativeQuery.getResultList();


        for (Object[] o : resultList) {

            Assertions.assertNotEquals(o[0], "alihan bayraktar");
            Assertions.assertNotEquals(o[1], 123);

        }


    }

}