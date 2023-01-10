package com.poc.jpapaging.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Proposal {

    @Id
    private Integer prepId;
    private Integer revisionId;
    private String title;
    private String piName;
    private Date dueDate;

}
