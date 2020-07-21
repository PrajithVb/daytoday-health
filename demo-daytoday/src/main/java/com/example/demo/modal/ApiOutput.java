package com.example.demo.modal;



import com.example.demo.util.ErrorGroup;
import com.example.demo.util.SubErrorCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiOutput {
    private boolean success;
    private ErrorGroup errorGroup;
    private SubErrorCode subErrorCode;
    private String message;

    public ApiOutput(boolean success){
        this.success = success;
    }
    
    
}