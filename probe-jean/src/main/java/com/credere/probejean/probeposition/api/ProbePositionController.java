package com.credere.probejean.probeposition.api;

import com.credere.probejean.probeposition.domain.ProbePositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/probePosition")
@Api(value = "Probe Position")
public class ProbePositionController {

    @Autowired
    private ProbePositionService service;

    @PutMapping(path = "/reset")
    @ApiOperation(value = "Reseta a posição da Sonda")
    public void resetPosition() {
        service.reset();
    }

}
