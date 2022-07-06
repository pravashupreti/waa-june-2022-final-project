package edu.miu.amp.controller;


import edu.miu.amp.dto.request.UserUpdateDto;
import edu.miu.amp.dto.response.UserRegistrationResponse;
import edu.miu.amp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;


  @GetMapping
  public ResponseEntity<?> get(@RequestParam(required = false) String email) {
    if (email == null) {
      List<UserRegistrationResponse> users = userService.findAll();
      return ResponseEntity.ok(users);
    }
    return ResponseEntity.ok(userService.findByEmail(email));
  }

  @GetMapping("{id}")
  public ResponseEntity<UserRegistrationResponse> getById(@PathVariable Long id) {
    UserRegistrationResponse response = userService.findById(id);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserUpdateDto> update(@RequestBody UserUpdateDto userUpdateDto, @PathVariable Long id) {
    userUpdateDto = userService.update(id, userUpdateDto);
    return ResponseEntity.ok(userUpdateDto);
  }

  @PostMapping("/user-active/{id}")
  public ResponseEntity<Void> updateUserStatus(@PathVariable Long id) {
    userService.userIsActive(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
