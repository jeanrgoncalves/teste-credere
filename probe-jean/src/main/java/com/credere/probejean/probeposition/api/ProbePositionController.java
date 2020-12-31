package com.credere.probejean.probeposition.api;

import com.credere.probejean.probeposition.api.dto.ProbePositionDTO;
import com.credere.probejean.probeposition.api.dto.ProbePositionDTOAssembler;
import com.credere.probejean.probeposition.domain.ProbePosition;
import com.credere.probejean.probeposition.domain.ProbePositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/probePosition")
@Api(value = "Probe Position")
public class ProbePositionController {

    @Autowired
    private ProbePositionService service;

    @Autowired
    ProbePositionDTOAssembler assembler;

    @PutMapping(path = "/reset")
    @ApiOperation(value = "Reseta a posição da Sonda")
    public void reset() {
        service.reset();
    }

    @GetMapping
    @ApiOperation(value = "Retorna a posição atual da Sonda")
    public ResponseEntity<ProbePositionDTO> get() {
        ProbePositionDTO dto = assembler.fromEntity(service.get());
        return ResponseEntity.ok(dto);
    }

}
