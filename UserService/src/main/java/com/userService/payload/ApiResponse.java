//package com.userService.payload;
//
//import lombok.*;
//import org.springframework.data.repository.NoRepositoryBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoRepositoryBean
//@Builder
//public class ApiResponse {
//
//    private String message;
//    private boolean success;
//    private HttpStatus status;
//
////    // private constructor to enforce the use of the builder
////    private ApiResponse(String message, boolean success, HttpStatus status) {
////        this.message = message;
////        this.success = success;
////        this.status = status;
////    }
////
////    // Builder method to create an instance of ApiResponse
////    public static ApiResponseBuilder builder() {
////        return new ApiResponseBuilder();
////    }
////
////    public String getMessage() {
////        return message;
////    }
////
////    public boolean isSuccess() {
////        return success;
////    }
////
////    public HttpStatus getStatus() {
////        return status;
////    }
////
////    // Builder class
////    public static class ApiResponseBuilder {
////        private String message;
////        private boolean success;
////        private HttpStatus status;
////
////        public ApiResponseBuilder message(String message) {
////            this.message = message;
////            return this;
////        }
////
////        public ApiResponseBuilder success(boolean success) {
////            this.success = success;
////            return this;
////        }
////
////        public ApiResponseBuilder status(HttpStatus status) {
////            this.status = status;
////            return this;
////        }
////
////        public ApiResponse build() {
////            return new ApiResponse(message, success, status);
////        }
////    }
//}
