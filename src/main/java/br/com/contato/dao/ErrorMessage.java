package br.com.contato.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ErrorMessage {
    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String messageError;
}
