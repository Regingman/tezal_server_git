package tezAlServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tezAlServer.domain.Container;
import tezAlServer.domain.ContainerCategory;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllContainersByCategory {
    private long id;
    private String name;
    private List<Container> container;

    public static AllContainersByCategory fromUser(List<Container> container, ContainerCategory containerCategory) {
        AllContainersByCategory allContainersByCategory = new AllContainersByCategory();
        allContainersByCategory.setId(containerCategory.getId());
        allContainersByCategory.setName(containerCategory.getName());
        allContainersByCategory.setContainer(container);
        return allContainersByCategory;
    }
}
