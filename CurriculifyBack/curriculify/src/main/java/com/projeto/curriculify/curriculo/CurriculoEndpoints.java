package com.projeto.curriculify.curriculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.InputStreamResource;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.projeto.curriculify.usuario.UsuarioCadastrarRequestObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin(origins = "*")
public class CurriculoEndpoints {
	
	@PostMapping ("/jpa/criarCurriculo")
	public ResponseEntity<InputStreamResource> CriarCurriculoPdf(@RequestBody String html, @RequestParam(name = "idUsuario", required = false) String idUsuario) throws FileNotFoundException, DocumentException {
		String userPrefix = "unknown";
		if (idUsuario != null) {
			userPrefix = idUsuario;
		}
		
		String filePath = "curriculos/" + userPrefix + "-curriculo.pdf";   
		
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		renderer.createPDF(new FileOutputStream(filePath));
		
		InputStream inputStream = new FileInputStream(filePath);
		
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=curriculo.pdf");
		
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(inputStream));
	}
}
