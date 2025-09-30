package kr.co.sboard.service;

import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.entity.User;
import kr.co.sboard.repository.TermsRepository;
import kr.co.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;


    public void save(UserDTO userDTO) {
        // 비밀번호 암호화
        String encodedPass = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encodedPass);

        // DTO를 Entity로 변환
        User user = modelMapper.map(userDTO, User.class);

        userRepository.save(user);
    }

    public UserDTO getUser(String usid){

        Optional<User> optUser = userRepository.findById(usid);

        if(optUser.isPresent()){

            User user = optUser.get();
            return modelMapper.map(user, UserDTO.class);
        }
        return null;
    }

    public List<UserDTO> getUserAll(){
        return null;
    }
    public void modify(UserDTO userDTO){}
    public void remove(String usid){}

    public int countUser(String type, String value){

        int count = 0;

        if(type.equals("usid")){
            count = userRepository.countByUsid(value);
        }else if(type.equals("nick")){
            count = userRepository.countByNick(value);
        }else if(type.equals("email")){
            count = userRepository.countByEmail(value);

            if(count == 0){
                // 인증코드 이메일 전송
                emailService.sendCode(value);
            }

        }else if(type.equals("hp")){
            count = userRepository.countByHp(value);
        }
        return count;
    }

}