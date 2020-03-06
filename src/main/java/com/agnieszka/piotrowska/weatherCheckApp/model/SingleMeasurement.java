package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SingleMeasurement {

    private String fromDateTime;
    private String tillDateTime;
    private List<Value> values;
    private List <Index> indexes;
    private List <Standards> standards;

}
