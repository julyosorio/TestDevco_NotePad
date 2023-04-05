package co.com.iris.certification.models.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {

    private String categoryName;
    private String tagsList;
    private String numberCategoryColor;
}
