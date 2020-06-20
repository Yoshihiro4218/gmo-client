package com.yoshi.gmoclient.domain.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    @NonNull
    private String sub;
    @NonNull
    private String email;
    private String gmoToken;
}
