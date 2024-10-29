package com.workintech.fswebs18challengemaven;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FswebS18ChallengeMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(FswebS18ChallengeMavenApplication.class, args);
		Card card = new Card();
		card.setId(1L);
		card.setColor(Color.HEARTH);
		card.setType(Type.ACE);
		card.setValue(null);

		System.out.println(card.getType());
	}

}
