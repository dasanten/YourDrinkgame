package de.dasanten.YourDrinkgame.controller.dto;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
public class CardSetDTO {

    private String id;

    private String name;
    private String type;
    private int version;
    private boolean isReported;
    private int reports;
    private String Token;
}
