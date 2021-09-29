package com.amol.spring.openfiegn.openfiegndemo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Post {
    private String userId;
    private String id;
    private String title;
    private String body;
}
