package com.graduationthesis.lungpanda.deliveryfast_deliman.model.SignIn;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by LungPanda on 11/13/2017.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class SignIn {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private  String password;
}
