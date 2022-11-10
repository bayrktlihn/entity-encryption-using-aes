package io.bayrktlihn.entityencryptionusingaes.entity;

import io.bayrktlihn.entityencryptionusingaes.config.AesEncryptor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "card_detail")
@SequenceGenerator(name = "cardDetailSeqGen", sequenceName = "card_detail_id_seq")
public class CardDetail {

    @Id
    @GeneratedValue(generator = "cardDetailSeqGen")
    private Integer id;

    @Convert(converter = AesEncryptor.class)
    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Convert(converter = AesEncryptor.class)
    @Column(name = "cvv")
    private Integer cvv;

    @Convert(converter = AesEncryptor.class)
    @Column(name = "amount")
    private Double amount;

    @Convert(converter = AesEncryptor.class)
    @Column(name = "is_active")
    private Boolean isActive;

}
