package com.pfe.back.BackPfe;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.text.ParseException;

import com.pfe.back.BackPfe.EmailSender.SendEmailService;
import com.pfe.back.BackPfe.EmailSender.emailinfo;
import com.pfe.back.BackPfe.entities.Authority;
import com.pfe.back.BackPfe.entities.User;
import com.pfe.back.BackPfe.repository.UserDetailsRepository;
import com.pfe.back.BackPfe.services.AuthorityService;

@SpringBootApplication
public class BackPfeApplication {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private SendEmailService SES;
	public static void main(String[] args) {
		SpringApplication.run(BackPfeApplication.class, args);
	}
	
	@PostConstruct
	protected void init() {
		
		Authority a = new Authority(null, "Admin");
		Authority b = new Authority(null, "User_Candidat");
		Authority c = new Authority(null, "User_Professer");

		authorityService.add(a);
		authorityService.add(b);
		authorityService.add(c);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		User user=new User();
		
		user.setUserName("sirine");
		user.setNom("sirine");
	    user.setPrenom("amdouni");
	    user.setPassword(passwordEncoder.encode("sirine123"));
		user.setAdresse("mornaguia");
		user.setEmail("amdounisirine80@gmail.com");
		user.setNumero_de_telephone("+216 22929388");
		try {
			user.setDate_de_naissance(formatter.parse("2000-02-22"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setGenre("Femme");
		user.setEtat_civil("Celibataire");
		user.setAuthority(a);
      
		User user2=new User();
		
		user2.setUserName("sarra");
		user2.setNom("mannai");
	    user2.setPrenom("sarra");
	    user2.setPassword(passwordEncoder.encode("sarra123"));
		user2.setAdresse("mornaguia");
		user2.setEmail("sarramnaai80@gmail.com");
		user2.setNumero_de_telephone("+216 22929388");
		try {
			user2.setDate_de_naissance(formatter.parse("2000-04-02"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user2.setGenre("Femme");
		user2.setEtat_civil("Celibataire");
		user2.setAuthority(c);
		if(userDetailsRepository.findByUserName(user2.getUsername()) == null && userDetailsRepository.findByUserName(user2.getUsername()) ==null)
		{
		userDetailsRepository.save(user);
		userDetailsRepository.save(user2);
		}
        emailinfo M= new emailinfo();
        M.setBody("hello");
        M.setDestinataire("amdounisirine80@gmail.com");
		SES.ajouterMail(M);
		
	}
	
	
	

}
