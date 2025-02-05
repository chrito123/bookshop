package com.sanchezc.bookshop.dto;

public record ErrorResponse(int status, String error, String message) {

}
