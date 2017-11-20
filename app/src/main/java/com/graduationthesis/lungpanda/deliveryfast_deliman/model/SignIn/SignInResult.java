package com.graduationthesis.lungpanda.deliveryfast_deliman.model.SignIn;

import com.google.gson.annotations.SerializedName;
import com.graduationthesis.lungpanda.deliveryfast_deliman.model.ErrorData;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by LungPanda on 11/13/2017.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class SignInResult {
    @SerializedName("status")
    private Boolean status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private SignInData data;
}
