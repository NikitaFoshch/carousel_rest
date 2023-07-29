package lab.space.mapper;

import lab.space.entity.Carousel;
import lab.space.model.CarouselResponse;
import lab.space.model.CarouselResponseByReact;
import lab.space.model.CarouselSaveResponse;

import java.util.List;
import java.util.stream.Collectors;

public interface CarouselMapper {
    static CarouselResponseByReact toCarouselResponseByReact(List<Carousel> Carousel) {
        return CarouselResponseByReact.builder()
                .carousel(Carousel.stream().map(CarouselMapper::toSimplifiedDto).collect(Collectors.toList()))
                .build();
    }

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

    static CarouselSaveResponse toCarouselSaveResponse(Carousel carousel) {
        return CarouselSaveResponse.builder()
                .id(carousel.getId())
                .build();
    }
}
