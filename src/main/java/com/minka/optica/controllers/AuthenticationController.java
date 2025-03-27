package com.minka.optica.controllers;

import com.minka.optica.dto.auth.AuthenticationRequest;
import com.minka.optica.dto.auth.AuthenticationResponse;
import com.minka.optica.services.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @GetMapping("valídate-token")
  public ResponseEntity<Boolean> validate(@RequestParam String jwt) {
    boolean isTokenValid = authenticationService.validateToken(jwt);
    return ResponseEntity.ok(isTokenValid);
  }

  @PostMapping("authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody @Valid AuthenticationRequest authenticationRequest) {

    AuthenticationResponse rsp = authenticationService.login(authenticationRequest);
    return ResponseEntity.ok(rsp);
  }
}
