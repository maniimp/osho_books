package com.osho.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.osho.common.FileStorageException;
import com.osho.common.UploadFileResponse;
import com.osho.model.Images;
import com.osho.repository.ImagesRepository;

@Service
public class ImagesServices {

	@Autowired
	ImagesRepository imageRepository;
	
	
	public UploadFileResponse saveImage(MultipartFile file) throws IOException
	{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.contains(".."))
		{
			throw new FileStorageException("Storage not successful due to path incorrect: "+fileName);
		}
		
		Images image = new Images();
		image.setImage_description(file.getName());
		image.setImage_name(file.getOriginalFilename());
		image.setImage_size(file.getSize());
		imageRepository.save(image);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/images/")
                .path(String.valueOf(image.getImage_id()))
                .toUriString();

        return new UploadFileResponse(image.getImage_name(), fileDownloadUri,
                file.getContentType(), file.getSize());
	}
	
	public Images getImage(Long imageId)
	{
		return imageRepository.findById(imageId).get();
	}
	
	
	
}
