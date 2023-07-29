package lab.space.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.entity.Carousel;
import lab.space.mapper.CarouselMapper;
import lab.space.model.CarouselResponseByReact;
import lab.space.model.CarouselSaveRequest;
import lab.space.model.CarouselSaveResponse;
import lab.space.model.CarouselUpdateRequest;
import lab.space.repository.CarouselRepository;
import lab.space.service.CarouselService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarouselServiceImpl implements CarouselService {
    private final CarouselRepository carouselRepository;

    @Override
    public Carousel getCarouselById(Long id) throws EntityNotFoundException {
        return carouselRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carousel not found by id " + id));
    }

    @Override
    public CarouselSaveResponse getLastCarousel() {
        return CarouselMapper.toCarouselSaveResponse(
                carouselRepository
                        .findAll(Sort.by(Sort.Direction.DESC, "createAt"))
                        .get(0)
        );
    }

    @Override
    public List<Carousel> getAllCarousel() {
        return carouselRepository.findAll(Sort.by(Sort.Direction.DESC, "updateAt"));
    }

    @Override
    public CarouselResponseByReact getAllCarouselWithDto() {
        return CarouselMapper.toCarouselResponseByReact(getAllCarousel());
    }

    @Override
    public CarouselSaveResponse saveCarousel(CarouselSaveRequest carouselSaveRequest) {
        carouselRepository.save(
                new Carousel()
                        .setLogin(carouselSaveRequest.login())
                        .setPassword(carouselSaveRequest.password())
                        .setImgUrl(carouselSaveRequest.imgUrl())
                        .setDescription(carouselSaveRequest.description())
                        .setProjectName(carouselSaveRequest.projectName())
                        .setProjectUrl(carouselSaveRequest.projectUrl())
        );
        return getLastCarousel();
    }

    @Override
    public ResponseEntity<?> updateCarousel(CarouselUpdateRequest carouselUpdateRequest) {
        try {
            carouselRepository.save(
                    getCarouselById(carouselUpdateRequest.id())
                            .setLogin(carouselUpdateRequest.login())
                            .setPassword(carouselUpdateRequest.password())
                            .setImgUrl(carouselUpdateRequest.imgUrl())
                            .setDescription(carouselUpdateRequest.description())
                            .setProjectName(carouselUpdateRequest.projectName())
                            .setProjectUrl(carouselUpdateRequest.projectUrl())
            );
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }

    }

    @Override
    public ResponseEntity<?> deleteCarouselById(Long id) {
        try {
            carouselRepository.delete(getCarouselById(id));
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
