package com.osho.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.osho.model.Images;
import com.osho.repository.ImagesRepository;
import com.osho.services.ImagesServices;

@RestController
@RequestMapping("/images")
public class ImagesController {
	
	@Autowired
	ImagesServices imagesServices;
	
	@Autowired
	ImagesRepository imagesRepository;
	
	
	@GetMapping
	public List<Images> getImages()
	{
		return imagesRepository.findAll();
	}
	
	@GetMapping("/{imageId}")
	public Images getImagesById(@RequestParam("imageId") Long imageId)
	{
		return imagesServices.getImage(imageId);
	}
	
	@PostMapping
	public String saveImages(@RequestParam("image") MultipartFile image) throws IOException
	{
		imagesServices.saveImage(image);
		return "Image :"+image.getOriginalFilename()+" saved successfully";
	}

}
