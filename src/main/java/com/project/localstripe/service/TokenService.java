package com.project.localstripe.service;

import com.project.localstripe.request.CreateTokenDTO;
public interface TokenService {

    public String createToken(CreateTokenDTO createTokenDTO);
}
