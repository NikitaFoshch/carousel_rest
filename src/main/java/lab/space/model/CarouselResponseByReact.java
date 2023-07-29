package lab.space.model;

import lombok.Builder;

import java.util.List;

@Builder
public record CarouselResponseByReact(
        List<CarouselResponse> carousel
) {
}
