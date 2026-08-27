package com.learn.test.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDocument {
    @Id
    private String id;
    private String email;
    private String name;
    private boolean emailVerified;
    private boolean active;
    private Integer otp;
}
