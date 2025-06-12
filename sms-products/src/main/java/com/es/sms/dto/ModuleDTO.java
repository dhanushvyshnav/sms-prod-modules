package com.es.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDTO {

    private Integer moduleId;
    private String moduleDesc;
    private String startdate;
    private String enddate;
}
