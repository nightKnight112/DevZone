package com.project.devZone.DevZone.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginBody {

    String userName;
    String password;

}
