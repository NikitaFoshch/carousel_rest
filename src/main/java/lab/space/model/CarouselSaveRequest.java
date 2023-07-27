package lab.space.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CarouselSaveRequest(
        @NotBlank(message = "Must be specified")
        @Size(max = 100, message = "Must be no more than {max} symbols")
        @Schema(name = "imgUrl", example = "https://www.baeldung.com/wp-content/uploads/2021/08/Baeldung-Featured-Image.png")
        String imgUrl,

        @NotBlank(message = "Must be specified")
        @Size(max = 2500, message = "Must be no more than {max} symbols")
        @Schema(name = "description", example = "Ivan Ivanov")
        String description,

        @NotBlank(message = "Must be specified")
        @Size(max = 50, message = "Must be no more than {max} symbols")
        @Schema(name = "login", example = "admin@gmail.com")
        String login,

        @NotBlank(message = "Must be specified")
        @Size(max = 100, message = "Must be no more than {max} symbols")
        @Schema(name = "password", example = "1234")
        String password,

        @NotBlank(message = "Must be specified")
        @Size(max = 50, message = "Must be no more than {max} symbols")
        @Schema(name = "projectName", example = "Kino-CMS")
        String projectName,

        @NotBlank(message = "Must be specified")
        @Size(max = 100, message = "Must be no more than {max} symbols")
        @Schema(name = "projectUrl", example = "https://mvnrepository.com/")
        String projectUrl
) {
}
