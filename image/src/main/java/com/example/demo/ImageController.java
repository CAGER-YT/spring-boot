package com.example.demo;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("image")
public class ImageController {

	@Autowired
	private ImageRepository imageRepository;

	@PostMapping("upload")
	public ResponseEntity<String> uploadImage(@RequestBody byte[] imageData) throws SerialException, SQLException {
	    // Create an Image entity to represent the uploaded image
	    Image image = new Image();
	    // Set the image data to the entity
	    image.setPhoto(new javax.sql.rowset.serial.SerialBlob(imageData)); // Assuming Image entity has a field named photo of type Blob

	    // Save the image entity to the database
	    imageRepository.save(image);

	    // Return a response indicating success
	    return ResponseEntity.status(HttpStatus.CREATED).body("Image uploaded successfully");
	}

	// Return the image from the database using ResponseEntity
	@GetMapping("database/{id}")
	public ResponseEntity<byte[]> fromDatabaseAsResEntity(@PathVariable("id") Integer id) throws SQLException {

		Optional<Image> primeMinisterOfIndia = imageRepository.findById(id);
		byte[] imageBytes = null;
		if (primeMinisterOfIndia.isPresent()) {

			imageBytes = primeMinisterOfIndia.get().getPhoto().getBytes(1,
					(int) primeMinisterOfIndia.get().getPhoto().length());
		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

	// Return the image from the database using HttpServletResponse
	@GetMapping(value = "database1/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void fromDatabaseAsHttpServResp(@PathVariable("id") Integer id, HttpServletResponse response)
			throws SQLException, IOException {

		Optional<Image> primeMinisterOfIndia = imageRepository.findById(id);

		if (primeMinisterOfIndia.isPresent()) {

			Blob image = primeMinisterOfIndia.get().getPhoto();

			StreamUtils.copy(image.getBinaryStream(), response.getOutputStream());
		}
	}

	// Return the image from the classpath location using ResponseEntity
	@GetMapping(value = "classpath")
	public ResponseEntity<byte[]> fromClasspathAsResEntity() throws IOException {

		ClassPathResource imageFile = new ClassPathResource("pm-india/modi.jpg");

		byte[] imageBytes = StreamUtils.copyToByteArray(imageFile.getInputStream());

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

	// Return the image from the classpath location using HttpServletResponse
	@GetMapping(value = "classpath1", produces = MediaType.IMAGE_JPEG_VALUE)
	public void fromClasspathAsHttpServResp(HttpServletResponse response) throws IOException {

		ClassPathResource imageFile = new ClassPathResource("pm-india/vajpayee.jpg");

		StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
	}
}