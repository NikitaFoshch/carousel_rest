package lab.space.mapper;

import lab.space.entity.Carousel;
import lab.space.model.CarouselResponse;

public interface CarouselMapper {

    static CarouselResponse toSimplifiedDto(Carousel carousel) {
        return CarouselResponse.builder()
                .id(carousel.getId())
                .login(carousel.getLogin())
                .password(carousel.getPassword())
                .imgUrl(carousel.getImgUrl())
                .description(carousel.getDescription())
                .projectName(carousel.getProjectName())
                .projectUrl(carousel.getProjectUrl())
                .build();
    }
}
