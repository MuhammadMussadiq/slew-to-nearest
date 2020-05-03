package com.assignment.slewtonearest.service;

import com.assignment.slewtonearest.document.Camera;
import com.assignment.slewtonearest.dto.CameraDto;
import com.assignment.slewtonearest.exception.AppException;
import com.assignment.slewtonearest.repository.CameraRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraServiceImpl implements CameraService {
    private Logger LOGGER = LoggerFactory.getLogger(CameraServiceImpl.class);

    @Autowired
    private CameraRepository cameraRepository;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void saveCamera(CameraDto dto) {
        Camera camera = mapper.convertValue(dto, Camera.class);
        camera = cameraRepository.save(camera);
        LOGGER.info("Camera has been saved successfully with id: {}", camera.getId());
    }

    @Override
    public void updateCamera(CameraDto dto) {
        Optional<Camera> byId = cameraRepository.findById(dto.getId());
        Camera camera = byId
                .orElseThrow((() -> new AppException(HttpStatus.BAD_REQUEST, "No data found against given id: " + dto.getId())));
        if (StringUtils.isNotBlank(dto.getCameraName())) {
            camera.setCameraName(dto.getCameraName());
        }
        if (StringUtils.isNotBlank(dto.getCameraType())) {
            camera.setCameraType(dto.getCameraType());
        }
        if (StringUtils.isNotBlank(dto.getLatitude())) {
            camera.setLatitude(dto.getLatitude());
        }
        if (StringUtils.isNotBlank(dto.getLongitude())) {
            camera.setLongitude(dto.getLongitude());
        }
        if (StringUtils.isNotBlank(dto.getAzimuth())) {
            camera.setAzimuth(dto.getAzimuth());
        }

        camera = cameraRepository.save(camera);
        LOGGER.info("Camera has been updated successfully against id: {}", camera.getId());
    }

    @Override
    public List<CameraDto> getAllCameras() {
        List<Camera> cameras = cameraRepository.findAll();
        List<CameraDto> cameraDtos = mapper.convertValue(cameras, new TypeReference<List<CameraDto>>() {
        });
        return cameraDtos;
    }

    @Override
    public CameraDto getCameraById(String cameraId) {
        LOGGER.info("Finding result by given camera id: {}", cameraId);
        Optional<Camera> byId = cameraRepository.findById(cameraId);
        Camera camera = byId
                .orElseThrow((() -> new AppException(HttpStatus.NOT_FOUND, "No camera exist against given id: " + cameraId)));

        return mapper.convertValue(camera, CameraDto.class);
    }
}
