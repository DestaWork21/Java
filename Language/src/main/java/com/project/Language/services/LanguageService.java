package com.project.Language.services;

import java.util.ArrayList;
import java.util.List;
import com.project.Language.repositories.LanguageRepository;
import com.project.Language.models.Language;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
	// Member variables / service initializations go here
	private LanguageRepository LanguageRepository;
		
	public LanguageService(LanguageRepository LanguageRepository){
		this.LanguageRepository = LanguageRepository;

	}
	
	// Crud methods to act on services go here.
	public ArrayList<Language> allLanguages(){
		return (ArrayList<Language>) LanguageRepository.findAll();
	}
	public void addLanguage(Language language) {

		LanguageRepository.save(language);

	}

	public void destroyLanguage(Long id) {

		LanguageRepository.delete(id);

	}

	
	public Language findLanguageById(Long id) {

		return LanguageRepository.findOne(id);

	}

	public void updateLanguage(Language language) {

		LanguageRepository.save(language);

	}

}
