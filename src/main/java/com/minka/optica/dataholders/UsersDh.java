package com.minka.optica.dataholders;

import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDh implements Serializable {

  @Size(min = 4, max = 20, message = "Name field: The size must be between 4 and 20 characters")
  private String name;

  @Size(min = 4, max = 80, message = "Username field: The size must be between 4 and 80 characters")
  private String username;

  @Size(min = 8, max = 30, message = "Password field: The size must be between 8 and 30 characters")
  private String password;

  @Size(min = 8, max = 30, message = "RepeatPassword field: The size must be between 8 and 30 characters")
  private String repeatedPassword;
}
