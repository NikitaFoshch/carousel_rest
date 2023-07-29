package lab.space.service;

import lab.space.entity.Carousel;
import lab.space.model.CarouselResponseByReact;
import lab.space.model.CarouselSaveRequest;
import lab.space.model.CarouselSaveResponse;
import lab.space.model.CarouselUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarouselService {

    Carousel getCarouselById(Long id);
    CarouselSaveResponse getLastCarousel();

    List<Carousel> getAllCarousel();

    CarouselResponseByReact getAllCarouselWithDto();

    CarouselSaveResponse saveCarousel(CarouselSaveRequest carouselSaveRequest);

    ResponseEntity<?> updateCarousel(CarouselUpdateRequest carouselUpdateRequest);

    ResponseEntity<?> deleteCarouselById(Long id);

}
