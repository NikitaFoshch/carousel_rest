package lab.space.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CarouselResponse(
        Long id,

        String imgUrl,

        String description,

        String login,

        String password,

        String projectName,

        String projectUrl
) {
}
