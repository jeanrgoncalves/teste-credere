package com.credere.probejean.probeposition.api;

import com.credere.probejean.apierror.ApiError;
import com.credere.probejean.probeposition.api.dto.ProbePositionDTO;
import com.credere.probejean.probeposition.api.dto.ProbePositionDTOAssembler;
import com.credere.probejean.probeposition.domain.Command;
import com.credere.probejean.probeposition.domain.ProbePositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/probePosition")
@Api(value = "Probe Position")
public class ProbePositionController {

    @Autowired
    private ProbePositionService service;

    @Autowired
    private ProbePositionDTOAssembler assembler;

    @PutMapping(path = "/reset")
    @ApiOperation(value = "Reseta a posição da Sonda")
    public void reset() {
        service.reset();
    }

    @PostMapping
    @ApiOperation(value = "Executa os comandos na Sonda")
    public ResponseEntity<ProbePositionDTO> executeCommands(@RequestBody ArrayList<Command> commands) {
        try {
            ProbePositionDTO dto = assembler.fromEntity(service.executeCommands(commands));
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            ApiError apiError = new ApiError(e.getMessage());
            return new ResponseEntity(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @ApiOperation(value = "Retorna a posição atual da Sonda")
    public ResponseEntity<ProbePositionDTO> get() {
        ProbePositionDTO dto = assembler.fromEntity(service.get());
        return ResponseEntity.ok(dto);
    }

}
