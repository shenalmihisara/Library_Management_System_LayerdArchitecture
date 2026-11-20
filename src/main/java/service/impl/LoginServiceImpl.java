package service.impl;

import model.dto.LoginDTO;
import model.entity.UserEntity;
import repository.LoginRepository;
import service.LoginService;

public class LoginServiceImpl implements LoginService {
    LoginRepository loginRepository = new LoginRepository();

    @Override
    public boolean CheckUserNameAndPassword(LoginDTO loginDTO) {

        UserEntity userEntity = loginRepository.CheckUserNameAndPassword(loginDTO);

        if (
                userEntity.getUserName().equals(loginDTO.getUserName()) &&
                        userEntity.getPassword().equals(loginDTO.getPassword())
        ){
            return true;
        }

        return false;
    }
}
