package com.bruno.domain.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateDTO(@NotBlank String name, @NotNull Integer age) {

}
