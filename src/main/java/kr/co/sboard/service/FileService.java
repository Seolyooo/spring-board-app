package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileService {

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public List<FileDTO> upload(ArticleDTO articleDTO) {

        File fileUploadPath = new File(uploadPath);

        if (!fileUploadPath.exists()) {
            fileUploadPath.mkdirs();
        }

        String absolutePath = fileUploadPath.getAbsolutePath();
        List<MultipartFile> fileList = articleDTO.getFiles();

        // 반환용 리스트 생성
        List<FileDTO> fileDTOList = new ArrayList<>();

        for(MultipartFile multiFile : fileList) {

            // 파일 첨부 했으면
            if(!multiFile.isEmpty()){

                String oriName = multiFile.getOriginalFilename();
                String ext = oriName.substring(oriName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString() + ext;

                try {
                    // 파일 저장
                    multiFile.transferTo(new File(absolutePath, savedName));

                    // 반환용 파일 객체
                    FileDTO fileDTO = FileDTO.builder()
                            .oname(oriName)
                            .sname(savedName)
                            .build();

                    fileDTOList.add(fileDTO);

                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }

        return fileDTOList;
    }

    public void download(){}

    public void getFile(){}
    public void getFileAll(){}

    public void save(FileDTO fileDTO){
        kr.co.sboard.entity.File file = modelMapper.map(fileDTO, kr.co.sboard.entity.File.class);
        fileRepository.save(file);
    }
    public void modify(){}
    public void remove(){}


}