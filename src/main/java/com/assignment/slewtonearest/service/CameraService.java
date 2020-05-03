package com.assignment.slewtonearest.service;

import com.assignment.slewtonearest.dto.CameraDto;

import java.util.List;

public interface CameraService {

    void saveCamera(CameraDto dto);

    void updateCamera(CameraDto dto);

    List<CameraDto> getAllCameras();

    CameraDto getCameraById(String cameraId);
}
