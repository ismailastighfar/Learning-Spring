package com.me.secureservice.security.utils;

public class JwtUtil {
    public static final String SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    public static final String AUTH_HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final long EXPIRE_ACCESS_TOKEN = 2*60*1000;
    public static final long EXPIRE_REFRESH_TOKEN = 30*60*1000;
    public static final String REFRESH_PATH = "/refreshToken";
}
