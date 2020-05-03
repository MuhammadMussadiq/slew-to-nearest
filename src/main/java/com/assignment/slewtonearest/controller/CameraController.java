package com.assignment.slewtonearest.controller;

import com.assignment.slewtonearest.dto.CameraDto;
import com.assignment.slewtonearest.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/camera")
@CrossOrigin(origins = {"*"})
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @GetMapping(value = "get-all")
    public ResponseEntity<?> getAllCamera() {
        List<CameraDto> result = cameraService.getAllCameras();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @PostMapping(value = "save")
    public ResponseEntity<?> saveCamera(@RequestBody CameraDto dto) {
        cameraService.saveCamera(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "update")
    public ResponseEntity<?> updateCamera(@RequestBody CameraDto dto) {
        cameraService.updateCamera(dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "get-by-id/{id}")
    public ResponseEntity<?> getCameraById(@PathVariable("id") String cameraId) {
        CameraDto result = cameraService.getCameraById(cameraId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

}
