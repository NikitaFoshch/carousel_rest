package lab.space.service;

import lab.space.entity.Carousel;
import lab.space.model.CarouselResponse;
import lab.space.model.CarouselSaveRequest;
import lab.space.model.CarouselUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarouselService {

    Carousel getCarouselById(Long id);

    List<Carousel> getAllCarousel();

    List<CarouselResponse> getAllCarouselWithDto();

    void saveCarousel(CarouselSaveRequest carouselSaveRequest);

    ResponseEntity<?> updateCarousel(CarouselUpdateRequest carouselUpdateRequest);

    ResponseEntity<?> deleteCarouselById(Long id);

}
