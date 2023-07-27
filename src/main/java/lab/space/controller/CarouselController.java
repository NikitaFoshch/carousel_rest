package lab.space.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lab.space.entity.Carousel;
import lab.space.model.CarouselResponse;
import lab.space.model.CarouselSaveRequest;
import lab.space.model.CarouselUpdateRequest;
import lab.space.service.CarouselService;
import lab.space.util.ErrorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carousel")
@RequiredArgsConstructor
@Tag(name = "Carousel", description = "Operations related to Carousel")
public class CarouselController {
    private final CarouselService carouselService;

    @Operation(summary = "Get all carousel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    @GetMapping("get-all-carousel")
    public ResponseEntity<List<CarouselResponse>> getAllCarousel() {
        return ResponseEntity.ok(carouselService.getAllCarouselWithDto());
    }

    @Operation(summary = "Get all carousel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    @GetMapping("get-all-carousel-without-dto")
    public ResponseEntity<List<Carousel>> getAllCarouselWithoutDto() {
        return ResponseEntity.ok(carouselService.getAllCarousel());
    }


    @Operation(summary = "Save carousel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    @PostMapping("save-carousel")
    public ResponseEntity<?> saveCarousel(@Valid @RequestBody CarouselSaveRequest request,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorMapper.mapErrors(bindingResult));
        }
        carouselService.saveCarousel(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update carousel by id", description = "Enter your value")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @PutMapping("update-carousel")
    public ResponseEntity<?> updateCarousel(@Valid @RequestBody CarouselUpdateRequest request,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorMapper.mapErrors(bindingResult));
        }
        return carouselService.updateCarousel(request);
    }

    @Operation(summary = "Delete carousel by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @DeleteMapping("delete-carousel/{id}")
    public ResponseEntity<?> deleteCarousel(@PathVariable Long id) {
        if (id < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Carousel Id must be >=1");
        }
        return carouselService.deleteCarouselById(id);
    }

}
