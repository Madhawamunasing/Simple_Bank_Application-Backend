package com.example.assignment.collection.AccType;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "AccType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccType {
    @Id
    private String accTypeId;
    @NonNull @Indexed(unique = true)
    private String type;
    @NonNull
    private boolean isActive;


}
