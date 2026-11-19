package service;

import model.dto.LoginDTO;

public interface LoginService {
    boolean CheckUserNameAndPassword(LoginDTO loginDTO);
}
