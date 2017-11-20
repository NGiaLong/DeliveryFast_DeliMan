package com.graduationthesis.lungpanda.deliveryfast_deliman.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by LungPanda on 11/20/2017.
 */
@Data
public class ErrorData {
    @SerializedName("code")
    private int code;
}
