package de.dasanten.YourDrinkgame.util.mapper;

import de.dasanten.YourDrinkgame.controller.dto.CardDTO;

import de.dasanten.YourDrinkgame.repository.entity.CardEntity;
import de.dasanten.YourDrinkgame.util.mapper.CardSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    @Autowired
    CardSetMapper cardSetMapper;

    public CardDTO cardEntityToCardDTO(CardEntity cardEntity){
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(cardEntity.getId());
        cardDTO.setCardSetDTO(cardSetMapper.cardSetEntityToCardSetDTO(cardEntity.getCardSet()));
        cardDTO.setReported(cardEntity.isReported());
        cardDTO.setReports(cardEntity.getReports());
        cardDTO.setContent(cardEntity.getContent());
        cardDTO.setType(cardEntity.getType());
        return cardDTO;
    }

    public CardEntity cardDTOToCardEntity(CardDTO cardDTO){
        CardEntity cardEntity = new CardEntity();
        if (cardDTO.getId() != null){
            cardEntity.setId(cardDTO.getId());
        }
        cardEntity.setCardSet(cardSetMapper.cardSetDTOToCardSetEntity(cardDTO.getCardSetDTO()));
        cardEntity.setContent(cardDTO.getContent());
        cardEntity.setReported(cardDTO.isReported());
        cardEntity.setReports(cardDTO.getReports());
        cardEntity.setType(cardDTO.getType());
        return cardEntity;
    }


}