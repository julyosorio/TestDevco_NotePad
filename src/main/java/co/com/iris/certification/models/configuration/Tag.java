package co.com.iris.certification.models.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Tag {
    private String tagName;
    private String usersList;
    private String typeOperationList;
    private String category;

}
